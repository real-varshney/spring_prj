package com.example.demo.service.Implement;

import org.springframework.http.ResponseEntity;

public interface testService {

    ResponseEntity<?> user_add(String name);
    ResponseEntity<?> role_add(String name);
}
