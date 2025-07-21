package io.github.murilogustavo.creditevaluatorservice.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.murilogustavo.creditevaluatorservice.api.dto.*;
import io.github.murilogustavo.creditevaluatorservice.infra.client.CardResourceClient;
import io.github.murilogustavo.creditevaluatorservice.infra.client.ClientResourceClient;
import io.github.murilogustavo.creditevaluatorservice.infra.mquue.EmissionCardPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final ClientResourceClient clientClient;
    private final CardResourceClient cardClient;
    private final EmissionCardPublisher emissionCardPublisher;

    public ClientSituationDTO checkClientSituation(String cpf) {
        ResponseEntity<ClientDTO> clientResponse = clientClient.getClient(cpf);
        ResponseEntity<List<ClientCardDTO>> cardsResponse = cardClient.getCardsByClient(cpf);

        return ClientSituationDTO
                .builder()
                .client(clientResponse.getBody())
                .cards(cardsResponse.getBody())
                .build();
    }

    public ClientEvaluationDTO makeEvaluation(String cpf, Long income) {
        ClientDTO client = clientClient.getClient(cpf).getBody();
        List<CardDTO> cards = cardClient.getCardsIncomeUntil(income).getBody();

        List<ApprovedCardDTO> approvedCards =  cards.stream()
                .map(card -> {
                    BigDecimal ageFactor = BigDecimal.valueOf(client.getAge()).divide(BigDecimal.TEN);
                    BigDecimal approvedLimit = ageFactor.multiply(card.getBasicLimit());
                    return new ApprovedCardDTO(card.getName(), card.getFlag(), approvedLimit);
                })
                .toList();

        return new ClientEvaluationDTO(approvedCards);
    }

    public CardProtocolDTO solicitationCard(EmissionCardDTO emissionCard) throws JsonProcessingException {
        emissionCardPublisher.solicitationCard(emissionCard);
        return new CardProtocolDTO(UUID.randomUUID().toString());
    }
}
