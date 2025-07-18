package io.github.murilogustavo.creditevaluatorservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ClientSituationDTO {
    private ClientDTO client;
    private List<ClientCardDTO> cards;
}
