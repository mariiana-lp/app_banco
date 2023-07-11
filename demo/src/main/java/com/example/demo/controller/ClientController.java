package com.example.demo.controller;

import com.example.demo.entity.Client;

import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client clientDetails) {
        Client client = clientService.getClientById(id);
        client.setName(clientDetails.getName());
        client.setGender(clientDetails.getGender());
        client.setIdentification(clientDetails.getIdentification());
        client.setAge(clientDetails.getAge());
        client.setPhone(clientDetails.getPhone());
        client.setPassword(clientDetails.getPassword());
        client.setStatus(clientDetails.isStatus());
        client.setAddress(clientDetails.getAddress());
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }
}
