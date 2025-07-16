package io.github.murilogustavo.cardservice.domain.model;

import io.github.murilogustavo.cardservice.domain.enumeration.Flag;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Flag flag;

    private BigDecimal income;
    private BigDecimal basicLimit;

    public Card(String name, Flag flag, BigDecimal income, BigDecimal basicLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}
