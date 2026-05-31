package br.com.querino.autenticacao.dto;

import br.com.querino.autenticacao.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO {

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String password;

    @NotBlank(message = "O nome de usuário é obrigatório")
    private String userName;

    private String avatarUrl;
    private String bio;

    @NotNull(message = "O papel do usuário (Role) é obrigatório")
    private UserRole userRole;
}