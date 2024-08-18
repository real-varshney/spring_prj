package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {

    ResponseEntity<?> role_add(String name);
}
