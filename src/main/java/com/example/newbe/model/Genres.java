package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Thể Loại
    private Integer id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "songs_id", referencedColumnName = "id")
    private Songs songs;
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;
    //id nghệ sĩ
    @ManyToOne
    @JoinColumn(name = "artists_id", referencedColumnName = "id")
    private Artists artists;



}
