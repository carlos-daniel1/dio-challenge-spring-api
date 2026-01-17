package dio.web.api.DTO;

import dio.web.api.model.Bank;
import dio.web.api.model.Client;

public record ClientResponseDTO(Integer id, String name, Bank bancoDoCliente) {

    public ClientResponseDTO(Client client) {
        this(client.getId(), client.getName(), client.getBancoDoCliente());
    }
}
