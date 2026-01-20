package dio.web.api.controller;

import dio.web.api.DTO.client.ClientResponseDTO;
import dio.web.api.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientServiceImpl;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAll() {
        List<ClientResponseDTO> clients = clientServiceImpl.getAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable Integer id) {
        ClientResponseDTO client = clientServiceImpl.getById(id);
        return ResponseEntity.ok(client);
    }

}
