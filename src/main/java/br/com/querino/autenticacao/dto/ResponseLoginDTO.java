package br.com.querino.autenticacao.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLoginDTO {
    private String token;
    private ProfileDTO profile;
}
