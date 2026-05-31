package br.com.querino.autenticacao.model;

import br.com.querino.autenticacao.enums.UserRole;
import br.com.querino.autenticacao.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users_comum")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("USER")
public class UserComum extends User {

    public UserComum (
        String email, 
        String password, 
        String userName, 
        String avatarUrl, 
        String bio,
        UserStatus userStatus, 
        Boolean active
    ) 
    {
    super (
        email, 
        password, 
        userName, 
        avatarUrl, 
        bio, 
        UserRole.USER,
        userStatus, 
        active
    );
    }
}
