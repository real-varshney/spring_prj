package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    private int user_id;
    private String name;
    private List<Integer> client_ids;
    private List<Integer> role_ids;
}
