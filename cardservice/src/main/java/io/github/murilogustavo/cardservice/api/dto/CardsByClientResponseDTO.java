package io.github.murilogustavo.cardservice.api.dto;

import io.github.murilogustavo.cardservice.domain.model.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CardsByClientResponseDTO {
    private String name;
    private String flag;
    private BigDecimal limitReleased;

    public static CardsByClientResponseDTO fromModel(ClientCard clientCard) {
        return new CardsByClientResponseDTO(
                clientCard.getCard().getName(),
                clientCard.getCard().getFlag().toString(),
                clientCard.getLimit()
        );
    }
}
