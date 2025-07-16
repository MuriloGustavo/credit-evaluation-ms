package io.github.murilogustavo.cardservice.api.resource;

import io.github.murilogustavo.cardservice.api.dto.CardRequestDTO;
import io.github.murilogustavo.cardservice.api.dto.CardsByClientResponseDTO;
import io.github.murilogustavo.cardservice.application.CardService;
import io.github.murilogustavo.cardservice.application.ClientCardService;
import io.github.murilogustavo.cardservice.domain.model.Card;
import io.github.murilogustavo.cardservice.domain.model.ClientCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CardRequestDTO cardRequestDTO) {
        cardService.save(cardRequestDTO.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsIncomeUntil(@RequestParam("income") Long income) {
        List<Card> cards = cardService.getCardsIncomeLessThanEqual(income);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponseDTO>> getCardsByClient(@RequestParam("cpf") String cpf) {
        List<ClientCard> clientCards = clientCardService.listCardsByCpf(cpf);
        List<CardsByClientResponseDTO> result = clientCards.stream()
                .map(CardsByClientResponseDTO::fromModel)
                .toList();
        return ResponseEntity.ok(result);
    }
}
