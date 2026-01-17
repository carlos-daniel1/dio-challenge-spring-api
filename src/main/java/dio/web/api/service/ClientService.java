package dio.web.api.service;

import dio.web.api.model.Client;

public interface ClientService {
    Iterable<Client> findAll();

    Client findById(Integer id);

    void insert(Client client);

    void update(Integer id, Client client);

    void delete(Integer id);
}
