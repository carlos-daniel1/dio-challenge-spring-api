package dio.web.api.service.impl;

import dio.web.api.DTO.bank.BankResponseDTO;
import dio.web.api.DTO.client.ClientRequestDTO;
import dio.web.api.DTO.client.ClientResponseDTO;
import dio.web.api.model.Bank;
import dio.web.api.model.Client;
import dio.web.api.repository.BankRepository;
import dio.web.api.repository.ClientRepository;
import dio.web.api.service.BankService;
import dio.web.api.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // Singleton: injetar os componentes do spring com Autowired
    // Strategy: implementar os metodos definidos na interface
    // Facade: abstrair integracoes com subsistemas (BrasilAPI), provendo interface simples

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BankService bankService;

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
        Bank bank = getBankAndSaveIfNotExists(clientRequestDTO);
        Client client = new Client(clientRequestDTO.name(), bank);

        Client saveClient = clientRepository.save(client);
        return new ClientResponseDTO(saveClient);
    }

    @Override
    public ClientResponseDTO update(Integer id, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Bank bank = getBankAndSaveIfNotExists(clientRequestDTO);

        client.updateFromDTO(clientRequestDTO.name(), bank);

        Client updated = clientRepository.save(client);

        return new ClientResponseDTO(updated);
    }

    @Override
    public void delete(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clientRepository.deleteById(client.getId());
    }

    private Bank getBankAndSaveIfNotExists(ClientRequestDTO clientRequestDTO) {
        int bankCode = clientRequestDTO.bankCode();

        return bankRepository.findById(bankCode).orElseGet(() -> {
            BankResponseDTO dto = bankService.getInfoBank(bankCode);
            Bank newBank = new Bank(dto);
            return bankRepository.save(newBank);
        });
    }
}
