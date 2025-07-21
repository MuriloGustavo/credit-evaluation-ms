package io.github.murilogustavo.creditevaluatorservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emission-cards}")
    private String emissionCardsQueue;

    @Bean
    public Queue queueEmissionCards() {
        return new Queue(emissionCardsQueue, true);
    }
}
