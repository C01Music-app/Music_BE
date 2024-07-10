package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //người dùng
    private Integer id;
//    private String name;
    private String userName;
    private String phone;
    private String email;
    private String password;
//    @Column(columnDefinition = "text")
//    private String img;
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Playlists> playlists;


}
