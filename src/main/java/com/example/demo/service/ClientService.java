package com.example.demo.service;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ResponseEntity<?> client_add(String name);
    ResponseEntity<?> client_delete(Integer id);
    ResponseEntity<?> get_user(Integer client_id);
    ResponseEntity<?> get_user_on_role(Integer client_id, Integer role_id);
    ResponseEntity<?> client_update(Integer id, String name);
    ResponseEntity<?> getClient();
}
