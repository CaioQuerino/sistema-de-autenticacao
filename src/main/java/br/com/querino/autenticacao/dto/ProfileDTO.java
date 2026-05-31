package br.com.querino.autenticacao.dto;

import br.com.querino.autenticacao.enums.UserRole;
import br.com.querino.autenticacao.enums.UserStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Long id;
    private String email;
    private String userName;
    private String avatarUrl;
    private String bio;
    private UserRole userRole;
    private UserStatus userStatus;
    private boolean active;
    
    // Para UserGuest
    private String ipAddress;
}