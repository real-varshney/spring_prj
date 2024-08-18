package com.example.demo.controller;


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

    @GetMapping("/users")
    public ResponseEntity<?> getUser(@RequestParam int client_id){
        return clientService.get_user(client_id);
    }

    @GetMapping("/role-user")
    public ResponseEntity<?> getRoleSpecificUser(@RequestParam int client_id , @RequestParam int role_id){
        return null;
    }

}
