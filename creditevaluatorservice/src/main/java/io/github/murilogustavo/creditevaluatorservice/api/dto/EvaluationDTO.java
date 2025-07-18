package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.Data;

@Data
public class EvaluationDTO {
    private String cpf;
    private Long income;
}
