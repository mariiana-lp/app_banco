package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/client")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.saveClient(client));
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationException(ConstraintViolationException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
