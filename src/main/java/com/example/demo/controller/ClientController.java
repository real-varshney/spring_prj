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

    @DeleteMapping
    public ResponseEntity<?> DeleteClient(@RequestParam Integer id) {
        return clientService.client_delete(id);
    }

    @PatchMapping
    public ResponseEntity<?> updateClient(@RequestBody ClientDTO clientDTO) {
        return clientService.client_update(clientDTO.getId(), clientDTO.getName());
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@RequestParam int id){
        return  clientService.get_user(id);
    }

    @GetMapping("/user-role")
    public ResponseEntity<?> getUserOnRole(@RequestParam int rId, @RequestParam int cId){
        return clientService.get_user_on_role(cId, rId);
    }


}
