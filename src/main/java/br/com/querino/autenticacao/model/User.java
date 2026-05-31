package br.com.querino.autenticacao.model;

import br.com.querino.autenticacao.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "users")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    @Column(columnDefinition = "TEXT", length = 65535)
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private UserStatus userStatus;
    
    private Boolean active;

    public User (
        String email, 
        String password, 
        String userName, 
        String avatarUrl, 
        String bio, 
        UserRole userRole, 
        UserStatus userStatus, 
        boolean active
    ) 
    {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.active = active;
    }
}