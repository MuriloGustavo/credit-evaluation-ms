package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientCardDTO {
    private String name;
    private String flag;
    private BigDecimal releasedLimit;
}
