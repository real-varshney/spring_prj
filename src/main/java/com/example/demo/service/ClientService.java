package com.example.demo.service;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ResponseEntity<?> client_add(String name);
    ResponseEntity<?> client_delete(Integer id);
}
