package br.com.querino.autenticacao.controller;

import br.com.querino.autenticacao.dto.ApiResponse;
import br.com.querino.autenticacao.dto.AuthenticationRequest;
import br.com.querino.autenticacao.dto.AuthenticationResponse;
import br.com.querino.autenticacao.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<AuthenticationResponse>> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(ApiResponse.success(service.authenticate(request), "Login realizado com sucesso!"));
    }
}