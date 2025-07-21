package io.github.murilogustavo.creditevaluatorservice.infra.mquue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.murilogustavo.creditevaluatorservice.api.dto.EmissionCardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissionCardPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueEmissionCards;

    public void solicitationCard(EmissionCardDTO emissionCard) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(emissionCard);
        rabbitTemplate.convertAndSend(queueEmissionCards.getName(), json);
    }
}
