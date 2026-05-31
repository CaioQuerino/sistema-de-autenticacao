package br.com.querino.autenticacao.enums;

public enum UserStatus {
    ACTIVE("ACTIVE", "Usuário ativo"),
    INACTIVE("INACTIVE", "Usuário inativo"),    
    BLOCKED("BLOCKED", "Usuário bloqueado");

    private final String status;
    private final String description;

    UserStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
