package br.com.querino.autenticacao.repository;

import br.com.querino.autenticacao.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Métodos específicos para Admin podem ser adicionados aqui
}