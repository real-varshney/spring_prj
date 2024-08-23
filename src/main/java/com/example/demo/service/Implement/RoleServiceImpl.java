package com.example.demo.service.Implement;

import com.example.demo.Dto.ClientDTO;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepo;
import com.example.demo.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Component
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
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

    @Override
    public ResponseEntity<?> role_delete(Integer id) {
        try {
            Optional<Role> roleOpt = roleRepo.findById(id);

            if(roleOpt.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role does not exist with id: "+ id);
            }

            roleRepo.delete(roleOpt.get());
            return ResponseEntity.ok("Role Deleted successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> role_update(ClientDTO roleReq) {
        try {
            Optional<Role> roleOpt = roleRepo.findById(roleReq.getId());

            if(roleOpt.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role does not exist with id: "+ roleReq.getId());
            }
            Role role = roleOpt.get();
            role.setName(roleReq.getName());
            roleRepo.save(role);
            return ResponseEntity.ok("Role Updated successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> role_get() {
        try {
           List<Role> roleList =roleRepo.findAll();
           return ResponseEntity.ok(roleList);

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
