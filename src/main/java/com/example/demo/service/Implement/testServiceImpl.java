package com.example.demo.service.Implement;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class testServiceImpl implements  testService{

    private final UserRepo userRepo;

    public testServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public ResponseEntity<?> user_add(String name) {
        try {
            User user = new User();
            user.setName(name);
            userRepo.save(user);
            return ResponseEntity.ok("User added successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
