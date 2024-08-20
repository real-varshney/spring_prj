package com.example.demo.controller;


import com.example.demo.Dto.ClientDTO;
import com.example.demo.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public ResponseEntity<?> AddRole(@RequestParam String name){
        return roleService.role_add(name);
    }


    @DeleteMapping
    public ResponseEntity<?> DeleteRole(@RequestParam Integer id) {
        return roleService.role_delete(id);
    }

    @PatchMapping
    public ResponseEntity<?> updateRole(@RequestBody ClientDTO roleReq) {
        return roleService.role_update(roleReq);
    }
}
