package io.github.murilogustavo.cardservice.application;

import io.github.murilogustavo.cardservice.domain.model.Card;
import io.github.murilogustavo.cardservice.domain.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public Card save(Card card) {
        return repository.save(card);
    }

    public List<Card> getCardsIncomeLessThanEqual(Long income) {
        return repository.findByIncomeLessThanEqual(BigDecimal.valueOf(income));
    }
}
