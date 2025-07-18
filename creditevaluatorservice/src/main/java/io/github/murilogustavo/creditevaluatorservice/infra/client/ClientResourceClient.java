package io.github.murilogustavo.creditevaluatorservice.infra.client;

import io.github.murilogustavo.creditevaluatorservice.api.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "client-service", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<ClientDTO> getClient(@RequestParam("cpf") String cpf);
}
