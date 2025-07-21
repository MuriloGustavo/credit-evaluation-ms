package io.github.murilogustavo.creditevaluatorservice.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.murilogustavo.creditevaluatorservice.api.dto.*;
import io.github.murilogustavo.creditevaluatorservice.application.CreditEvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-evaluators")
@RequiredArgsConstructor
public class CreditEvaluatorController {

    private final CreditEvaluatorService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "/client-situation", params = "cpf")
    public ResponseEntity<ClientSituationDTO> checkClientSituation(@RequestParam("cpf") String cpf) {
        ClientSituationDTO clientSituationDTO = service.checkClientSituation(cpf);
        return ResponseEntity.ok(clientSituationDTO);
    }

    @PostMapping
    public ResponseEntity<ClientEvaluationDTO> makeEvaluation(@RequestBody EvaluationDTO evaluationDTO) {
        ClientEvaluationDTO clientEvaluationDTO = service.makeEvaluation(evaluationDTO.getCpf(), evaluationDTO.getIncome());
        return ResponseEntity.ok(clientEvaluationDTO);
    }

    @PostMapping(value = "/solicitation-card")
    public ResponseEntity<CardProtocolDTO> solicitationCard(@RequestBody EmissionCardDTO emissionCardDTO) throws JsonProcessingException {
        CardProtocolDTO cardProtocol = service.solicitationCard(emissionCardDTO);
        return ResponseEntity.ok(cardProtocol);
    }
}
