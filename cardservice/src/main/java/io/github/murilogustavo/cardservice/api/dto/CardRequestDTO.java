package io.github.murilogustavo.cardservice.api.dto;

import io.github.murilogustavo.cardservice.domain.enumeration.Flag;
import io.github.murilogustavo.cardservice.domain.model.Card;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardRequestDTO {
    private String name;
    private Flag flag;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toModel() {
        return new Card(name, flag, income, limit);
    }
}
