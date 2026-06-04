package br.com.querino.autenticacao.service;

import br.com.querino.autenticacao.dto.ProfileDTO;
import br.com.querino.autenticacao.dto.ProfileUpdateDTO;
import br.com.querino.autenticacao.dto.UpdatePasswordDTO;
import br.com.querino.autenticacao.dto.UserRegisterDTO;
import br.com.querino.autenticacao.enums.UserStatus;
import br.com.querino.autenticacao.model.*;
import br.com.querino.autenticacao.exception.BusinessException;
import br.com.querino.autenticacao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ProfileDTO registerUser(UserRegisterDTO dto) {
        validateUniqueness(dto);

        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        User user = createUserInstance(dto, encryptedPassword);

        User savedUser = userRepository.save(user);
        return convertToProfileDTO(savedUser);
    }

    public ProfileDTO getAuthenticatedUserProfile() {
        String email = SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getName();
            
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Usuário autenticado não encontrado na base de dados."));
        return convertToProfileDTO(user);
    }

    @Transactional
    public ProfileDTO updateAuthenticatedUserProfile(ProfileUpdateDTO dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado."));

        if (dto.getUserName() != null && !dto.getUserName().equals(user.getUsername())) {
            if (userRepository.existsByUserName(dto.getUserName())) {
                throw new BusinessException("Nome de usuário já está em uso.");
            }
            user.setUserName(dto.getUserName());
        }

        if (dto.getAvatarUrl() != null) user.setAvatarUrl(dto.getAvatarUrl());
        if (dto.getBio() != null) user.setBio(dto.getBio());

        return convertToProfileDTO(userRepository.save(user));
    }

    @Transactional
    public void changePassword(UpdatePasswordDTO dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado."));

        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new BusinessException("A senha atual está incorreta.");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }

    private void validateUniqueness(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("Email já cadastrado.");
        }
        if (userRepository.existsByUserName(dto.getUserName())) {
            throw new BusinessException("Nome de usuário já cadastrado.");
        }
    }

    private User createUserInstance(UserRegisterDTO dto, String encryptedPassword) {
        return switch (dto.getUserRole()) {
            case ADMIN -> new Admin(
                dto.getEmail(),
                encryptedPassword,
                dto.getUserName(),
                dto.getAvatarUrl(),
                dto.getBio(),
                true
            );
            case GUEST -> new UserGuest(
                dto.getEmail(),
                encryptedPassword,
                dto.getUserName(),
                dto.getAvatarUrl(),
                dto.getBio(),
                true,
                "0.0.0.0" // IP padrão, deve ser capturado no Controller
            );
            default -> new UserComum(
                dto.getEmail(),
                encryptedPassword,
                dto.getUserName(),
                dto.getAvatarUrl(),
                dto.getBio(),
                UserStatus.ACTIVE,
                true
            );
        };
    }

    private ProfileDTO convertToProfileDTO(User user) {
        return ProfileDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUsername())
                .userRole(user.getUserRole())
                .build();
    }
}