package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientEvaluationDTO {
    private List<ApprovedCardDTO> cards;
}
