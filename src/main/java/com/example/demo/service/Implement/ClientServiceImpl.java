package com.example.demo.service.Implement;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepo;
import com.example.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;


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
    public ResponseEntity<?> client_delete(Integer id) {
        try{
            Optional<Client> client = clientRepo.findById(id);
            client.ifPresent(clientRepo::delete);
            return ResponseEntity.ok("Client Deleted Successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
