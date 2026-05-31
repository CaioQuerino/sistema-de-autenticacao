package br.com.querino.autenticacao.repository;

import br.com.querino.autenticacao.model.UserComum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComumRepository extends JpaRepository<UserComum, Long> {
    // Métodos específicos para usuários comuns podem ser adicionados aqui
}