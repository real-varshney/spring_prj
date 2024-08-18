package com.example.demo.controller;


import com.example.demo.Dto.AddUserDto;
import com.example.demo.Dto.UpdateUserDto;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> AddUser(@RequestBody AddUserDto userReq){
        return userService.user_add(userReq);
    }

    @GetMapping("/get-role")
    public ResponseEntity<?> getRole(@RequestParam int user_id){
        return userService.get_role(user_id);
    }

    @GetMapping("/get-client")
    public ResponseEntity<?> getClient(@RequestParam int user_id){
        return userService.get_client(user_id);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam int user_id){
        return userService.delete_user(user_id);
    }

    @PatchMapping
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto userReq){
        return userService.update_user(userReq);
    }


}
