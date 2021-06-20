package com.example.springbootapp.service.impl;

import com.example.springbootapp.model.Client;
import com.example.springbootapp.repository.ClientRepository;
import com.example.springbootapp.service.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    @Transactional
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Optional<Client> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Client create(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public Client update(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
