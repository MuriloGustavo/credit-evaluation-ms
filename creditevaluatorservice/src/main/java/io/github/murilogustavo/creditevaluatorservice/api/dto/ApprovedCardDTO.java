package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ApprovedCardDTO {
    private String card;
    private String flag;
    private BigDecimal approvedLimit;
}
