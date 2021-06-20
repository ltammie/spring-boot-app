package com.example.springbootapp.controller;

import com.example.springbootapp.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client-management")
public class ClientController {

    @GetMapping("/health")
    public String health() {
        return "App is running!";
    }

    @GetMapping("/clients")
    public List<Client> getAll() {
        return null;
    }

    @GetMapping("/clients/{id}")
    public Client getById(@PathVariable("id") Long id) {
        return new Client();
    }
}
