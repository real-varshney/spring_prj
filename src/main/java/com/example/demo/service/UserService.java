package com.example.demo.service;

import com.example.demo.Dto.AddUserDto;
import com.example.demo.Dto.UpdateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseEntity<?> user_add(AddUserDto userReq);
    ResponseEntity<?> get_role(Integer user_id);
    ResponseEntity<?> get_client(Integer user_id);
    ResponseEntity<?> delete_user(Integer user_id);
    ResponseEntity<?> update_user(UpdateUserDto userReq);
}
