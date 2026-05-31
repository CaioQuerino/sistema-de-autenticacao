package br.com.querino.autenticacao.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoginDTO {
    private String email;
    private String password;
}
