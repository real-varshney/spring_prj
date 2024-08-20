package com.example.demo.service;

import com.example.demo.Dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {

    ResponseEntity<?> role_add(String name);
    ResponseEntity<?> role_delete(Integer id);
    ResponseEntity<?>  role_update(ClientDTO roleReq);
}
