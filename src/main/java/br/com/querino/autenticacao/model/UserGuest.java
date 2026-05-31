package br.com.querino.autenticacao.model;

import br.com.querino.autenticacao.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users_guest")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("GUEST")
public class UserGuest extends User {
    
    @Column(name = "ip_address")
    private String ipAddress;

    public UserGuest (
        String email, 
        String password, 
        String userName, 
        String avatarUrl, 
        String bio,
        Boolean active,
        String ipAddress
    ) 
    {
    super (
        email, 
        password, 
        userName, 
        avatarUrl, 
        bio, 
        UserRole.GUEST, 
        UserStatus.ACTIVE, 
        active
    );
    this.ipAddress = ipAddress;
    }
}