package dio.web.api.service.impl;

import dio.web.api.DTO.client.ClientRequestDTO;
import dio.web.api.DTO.client.ClientResponseDTO;
import dio.web.api.model.Client;
import dio.web.api.repository.ClientRepository;
import dio.web.api.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientResponseDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponseDTO::new)
                .toList();
    }

    @Override
    public ClientResponseDTO getById(Integer id) {
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Cliente não encontrado"));
        return new ClientResponseDTO(client);
    }

    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO) {
        Client client = new Client(clientRequestDTO);
        Client saveClient = clientRepository.save(client);
        return new ClientResponseDTO(saveClient);
    }

    @Override
    public ClientResponseDTO update(Integer id, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        client.updateFromDTO(clientRequestDTO);

        Client updated = clientRepository.save(client);

        return new ClientResponseDTO(updated);
    }

    @Override
    public void delete(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clientRepository.deleteById(client.getId());
    }
}
