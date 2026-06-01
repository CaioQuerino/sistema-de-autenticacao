package br.com.querino.autenticacao.dto;

import br.com.querino.autenticacao.enums.UserRole;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Long id;
    private String email;
    private String userName;
    private UserRole userRole;
}