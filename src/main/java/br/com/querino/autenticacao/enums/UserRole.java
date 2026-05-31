package br.com.querino.autenticacao.enums;

public enum UserRole {
    ADMIN("ADMIN", "Administrador do sistema"),
    USER("USER", "Usuário comum"),
    GUEST("GUEST", "Visitante");

    private final String role;
    private final String description;

    UserRole(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }
}