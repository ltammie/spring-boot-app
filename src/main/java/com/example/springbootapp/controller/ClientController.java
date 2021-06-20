package com.example.springbootapp.controller;

import com.example.springbootapp.model.Client;
import com.example.springbootapp.service.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client-management")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/clients")
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/clients/{id}")
    public Client getById(@PathVariable("id") Long id) {
        return service.getById(id).orElseThrow(() -> new ExpressionException("No client"));
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return service.create(client);
    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client) {
        return service.update(client);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClientById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }


}
