package io.github.murilogustavo.clientservice.api.dto;

import io.github.murilogustavo.clientservice.domain.model.Client;
import lombok.Data;

@Data
public class ClientDTO {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel() {
        return new Client(cpf, name, age);
    }
}
