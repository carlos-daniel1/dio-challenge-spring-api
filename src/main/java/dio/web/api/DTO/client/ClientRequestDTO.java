package dio.web.api.DTO.client;

import dio.web.api.model.Bank;

public record ClientRequestDTO(String name, Bank bancoDoCliente) {
}
