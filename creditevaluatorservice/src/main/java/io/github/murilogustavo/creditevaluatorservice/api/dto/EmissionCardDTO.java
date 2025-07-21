package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmissionCardDTO {
    private Long idCard;
    private String cpf;
    private BigDecimal releasedLimit;
}
