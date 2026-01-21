package dio.web.api.DTO.client;

import dio.web.api.entity.Bank;
import dio.web.api.entity.Client;

public record ClientResponseDTO(Integer id, String name, Bank bancoDoCliente) {

    public ClientResponseDTO(Client client) {
        this(client.getId(), client.getName(), client.getBancoDoCliente());
    }
}
