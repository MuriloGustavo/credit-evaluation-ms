package io.github.murilogustavo.clientservice.domain.repository;

import io.github.murilogustavo.clientservice.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);
}
