package br.com.querino.autenticacao.model;

import br.com.querino.autenticacao.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admins")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin (
        String email, 
        String password, 
        String userName, 
        String avatarUrl, 
        String bio,
        boolean active
    ) 
    {
        super (
            email, 
            password, 
            userName, 
            avatarUrl, 
            bio, 
            UserRole.ADMIN, 
            UserStatus.ACTIVE,
            active
        );
    }
}