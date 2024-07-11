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
public class Artists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Nghệ Sĩ
    private Integer id;
    private String name;
    @Column(columnDefinition = "text")
    private String img;
    private String info;

//    @ManyToOne
//    @JoinColumn(name = "album_id", referencedColumnName = "id")
//    private Album album;


}
