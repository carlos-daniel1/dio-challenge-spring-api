package dio.web.api.service;

import dio.web.api.DTO.client.ClientRequestDTO;
import dio.web.api.DTO.client.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    List<ClientResponseDTO> getAll();

    ClientResponseDTO getById(Integer id);

    ClientResponseDTO create(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO update(Integer id, ClientRequestDTO clientRequestDTO);

    void delete(Integer id);
}
