package io.github.murilogustavo.cardservice.domain.repository;

import io.github.murilogustavo.cardservice.domain.model.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    List<ClientCard> findByCpf(String cpf);
}
