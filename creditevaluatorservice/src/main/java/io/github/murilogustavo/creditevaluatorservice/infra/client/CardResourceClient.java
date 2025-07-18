package io.github.murilogustavo.creditevaluatorservice.infra.client;

import io.github.murilogustavo.creditevaluatorservice.api.dto.CardDTO;
import io.github.murilogustavo.creditevaluatorservice.api.dto.ClientCardDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "card-service", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCardDTO>> getCardsByClient(@RequestParam("cpf") String cpf);

    @GetMapping(params = "income")
    ResponseEntity<List<CardDTO>> getCardsIncomeUntil(@RequestParam("income") Long income);
}
