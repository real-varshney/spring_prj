package com.example.demo.service.Implement;

import com.example.demo.Dto.AddUserDto;
import com.example.demo.Dto.UpdateUserDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.ClientRepo;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;


@Component
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ClientRepo clientRepo;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepo, ClientRepo clientRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.clientRepo = clientRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public ResponseEntity<?> user_add(AddUserDto userReq) {
        try {
            User user = new User();
            user.setName(userReq.getName());

            for (int clientId : userReq.getClient_ids()) {
                Optional<Client> client = clientRepo.findById(clientId);
                if (client.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Client Id " + clientId + " is not valid.");
                }
                user.getClientList().add(client.get());
            }

            for (int roleId : userReq.getRole_ids()) {
                Optional<Role> role = roleRepo.findById(roleId);
                if (role.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Role Id " + roleId + " is not valid.");
                }
                user.getRoleList().add(role.get());
            }

            userRepo.save(user);
            return ResponseEntity.ok("User added successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> get_role(Integer user_id) {
        try {
            Optional<User> user = userRepo.findById(user_id);
            if(user.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: "+ user_id);
            }

            return ResponseEntity.ok(user.get().getRoleList());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @Override
    public ResponseEntity<?> get_client(Integer user_id) {
        try {
            Optional<User> user = userRepo.findById(user_id);
            if(user.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: "+ user_id);
            }

            return ResponseEntity.ok(user.get().getClientList());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> delete_user(Integer user_id) {
        try {
            Optional<User> user = userRepo.findById(user_id);
            if(user.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: "+ user_id);
            }

            userRepo.delete(user.get());
            return ResponseEntity.ok("User Deleted successfully with id: "+ user_id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<?> update_user(UpdateUserDto userReq) {
        try {
            Optional<User> userOpt = userRepo.findById(userReq.getUser_id());
            if (userOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: " + userReq.getUser_id());
            }

            User user = userOpt.get();

            if (userReq.getName() != null) {
                user.setName(userReq.getName());
            }
            Set<Role> existingRoles = user.getRoleList();
            if (userReq.getRole_ids() != null && !userReq.getRole_ids().isEmpty()) {
                for (int roleId : userReq.getRole_ids()) {
                    Optional<Role> roleOpt = roleRepo.findById(roleId);
                    roleOpt.ifPresent(existingRoles::add);
                }
            }

            Set<Client> existingClient = user.getClientList();
            if (userReq.getClient_ids() != null && !userReq.getClient_ids().isEmpty()) {
                for (int clientId : userReq.getClient_ids()) {
                    Optional<Client> clientOpt = clientRepo.findById(clientId);
                    clientOpt.ifPresent(existingClient::add);
                }
            }
            userRepo.save(user);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



}
