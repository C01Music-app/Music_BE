package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String imgSongs;

    private String title;
    @ManyToMany(mappedBy = "songs")
    private Set<Artists> artist;

    private String description;
    private String time;
    private LocalDate dateStart;

    @Column(columnDefinition = "text")
    private String lyrics;

    private Integer listens;
    private Integer likes;
    private String lableSong;

    @ManyToMany(mappedBy = "songs")
    private Set<Playlists> playlists;
}
