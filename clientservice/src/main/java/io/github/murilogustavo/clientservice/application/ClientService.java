package io.github.murilogustavo.clientservice.application;

import io.github.murilogustavo.clientservice.domain.model.Client;
import io.github.murilogustavo.clientservice.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

   private final ClientRepository repository;

   @Transactional
   public Client save(Client client) {
       return repository.save(client);
   }

   public Optional<Client> findById(String cpf) {
       return repository.findByCpf(cpf);
   }

}
