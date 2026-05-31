package br.com.querino.autenticacao.repository;

import br.com.querino.autenticacao.model.UserGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<UserGuest, Long> {
    // Permite buscar guests por IP, conforme o modelo definido
}
