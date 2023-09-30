package com.spring.api.SpringAPI.controllers;

import com.spring.api.SpringAPI.models.Client;

import com.spring.api.SpringAPI.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // convenience notation, saying that this is a REST controller, a class that will receive requests
@RequestMapping("/clients")  // so when a request arrives /clients will come to this controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;  // This will add an instance of ClientRepository and with it I can use the methods, even though it's an interface
    @GetMapping // When a request arrives with the http GET method in the clients uri, the method below will be used
    public List<Client> listClients(){
        return clientRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client registerClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping(path = {"/{clientId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId){
        return clientRepository.findById(clientId)
                .map(record -> {
                    clientRepository.deleteById(clientId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/{clientId}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getClientById(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
