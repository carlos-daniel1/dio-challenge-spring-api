package dio.web.api.DTO;

import dio.web.api.model.Bank;

public record ClientRequestDTO(String name, Bank bancoDoCliente) {
}
