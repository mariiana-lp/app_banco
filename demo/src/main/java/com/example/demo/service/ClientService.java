package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(long id) {
        try {
            clientRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }

    }
}
