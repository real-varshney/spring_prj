package com.example.demo.service.Implement;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepo;
import com.example.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public ResponseEntity<?> client_add(String name) {
        try {
            Client client = new Client();
            client.setName(name);
            clientRepo.save(client);
            return ResponseEntity.ok("Client added successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> get_user(Integer client_id) {
        return null;
    }

    @Override
    public ResponseEntity<?> get_user_on_role(Integer client_id, Integer role_id) {
        return null;
    }

}
