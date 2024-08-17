package com.example.demo.service.Implement;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class testServiceImpl implements  testService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public testServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
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

    @Override
    public ResponseEntity<?> role_add(String name) {
        try {
            Role role = new Role();
            role.setName(name);
            roleRepo.save(role);
            return ResponseEntity.ok("Role added successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
