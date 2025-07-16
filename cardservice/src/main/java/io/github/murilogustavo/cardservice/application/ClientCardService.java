package io.github.murilogustavo.cardservice.application;

import io.github.murilogustavo.cardservice.domain.model.ClientCard;
import io.github.murilogustavo.cardservice.domain.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository repository;

    public List<ClientCard> listCardsByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
