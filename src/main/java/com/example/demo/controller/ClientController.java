package com.example.demo.controller;


import com.example.demo.Dto.ClientDTO;
import com.example.demo.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping
    public ResponseEntity<?> AddClient(@RequestParam String name){
        return clientService.client_add(name);
    }

    @DeleteMapping("/{client-id}")
    public ResponseEntity<?> DeleteClient(@PathVariable Integer id) {
        return clientService.client_delete(id);
    }

    @PatchMapping("/{client-id}")
    public ResponseEntity<?> updateClient(ClientDTO clientDTO) {
        return clientService.client_update(clientDTO.getId(), clientDTO.getName());
    }
}
