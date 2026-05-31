package br.com.querino.autenticacao.service;

import br.com.querino.autenticacao.dto.ProfileDTO;
import br.com.querino.autenticacao.dto.UserRegisterDTO;
import br.com.querino.autenticacao.enums.UserStatus;
import br.com.querino.autenticacao.model.*;
import br.com.querino.autenticacao.config.SecurityConfig;
import br.com.querino.autenticacao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;

    @Transactional
    public ProfileDTO registerUser(UserRegisterDTO dto) {
        validateUniqueness(dto);

        String encryptedPassword = securityConfig.passwordEncoder().encode(dto.getPassword());
        User user = createUserInstance(dto, encryptedPassword);

        User savedUser = userRepository.save(user);
        return convertToProfileDTO(savedUser);
    }

    private void validateUniqueness(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }
        if (userRepository.existsByUserName(dto.getUserName())) {
            throw new RuntimeException("Nome de usuário já cadastrado.");
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
                "0.0.0.0"
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
                .userName(user.getUserName())
                .userRole(user.getUserRole())
                .build();
    }
}