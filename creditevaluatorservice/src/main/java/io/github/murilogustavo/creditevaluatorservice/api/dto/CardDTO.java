package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDTO {
    private Long id;
    private String name;
    private String flag;
    private BigDecimal basicLimit;
}
