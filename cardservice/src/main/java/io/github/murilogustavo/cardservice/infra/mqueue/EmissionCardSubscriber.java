package io.github.murilogustavo.cardservice.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.murilogustavo.cardservice.api.dto.EmissionCardDTO;
import io.github.murilogustavo.cardservice.domain.model.Card;
import io.github.murilogustavo.cardservice.domain.model.ClientCard;
import io.github.murilogustavo.cardservice.domain.repository.CardRepository;
import io.github.murilogustavo.cardservice.domain.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissionCardSubscriber {

    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.emission-cards}")
    public void solicitationCard(@Payload String payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        EmissionCardDTO emissionCard = mapper.readValue(payload, EmissionCardDTO.class);

        Card card = cardRepository.findById(emissionCard.getIdCard()).orElseThrow();

        ClientCard clientCard = ClientCard.builder()
                .card(card)
                .cpf(emissionCard.getCpf())
                .limit(emissionCard.getReleasedLimit())
                .build();

        clientCardRepository.save(clientCard);
    }

}
