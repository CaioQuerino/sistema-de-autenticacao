package br.com.querino.autenticacao.service;

import br.com.querino.autenticacao.dto.AuthenticationRequest;
import br.com.querino.autenticacao.dto.AuthenticationResponse;
import br.com.querino.autenticacao.dto.ProfileDTO;
import br.com.querino.autenticacao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        var jwtToken = jwtService.generateToken(user);
        
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .profile(ProfileDTO.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .userName(user.getUsername())
                        .userRole(user.getUserRole())
                        .build())
                .build();
    }
}