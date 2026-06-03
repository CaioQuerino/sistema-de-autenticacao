package br.com.querino.autenticacao.controller;

import br.com.querino.autenticacao.dto.*;
import br.com.querino.autenticacao.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProfileDTO>> register(@Valid @RequestBody UserRegisterDTO dto) {
        ProfileDTO profile = userService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(profile, "Usuário registrado com sucesso!"));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<ProfileDTO>> getCurrentUserProfile() {
        ProfileDTO profile = userService.getAuthenticatedUserProfile();
        return ResponseEntity.ok(ApiResponse.success(profile, "Perfil recuperado com sucesso."));
    }
}