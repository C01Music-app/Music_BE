package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
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


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
