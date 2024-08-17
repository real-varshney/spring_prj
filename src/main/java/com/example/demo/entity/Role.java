package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "r_id")
    private int rId;


    @Column(name = "name")
    private String name;

    @Column(name = "client_id", insertable=false, updatable=false)
    private Integer clientId;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "role_user",
//            joinColumns = {
//                    @JoinColumn(name = "r_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "u_id")
//            }
//    )
//    private List<User> userList;

}
