package com.example.springbootapp.service.api;

import com.example.springbootapp.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAll();
    Optional<Client> getById(Long id);
    Client create(Client client);
    Client update(Client client);
    void deleteById(Long id);
}
