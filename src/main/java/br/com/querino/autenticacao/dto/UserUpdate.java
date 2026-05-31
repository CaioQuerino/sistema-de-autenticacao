package br.com.querino.autenticacao.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate {
    
    @NotNull(message = "O ID é obrigatório")
    private Long id;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    @Size(min = 6, message = "A nova senha deve conter pelo menos 6 caracteres")
    private String password;

    @NotBlank(message = "O nome de usuário é obrigatório")
    @Size(min = 3, max = 20, message = "O nome de usuário deve ter entre 3 e 20 caracteres")
    private String userName;

    @Size(max = 500, message = "A URL do avatar deve conter no máximo 500 caracteres")
    private String avatarUrl;

    @Size(max = 65535, message = "A biografia deve conter no máximo 65535 caracteres")
    private String bio;
}