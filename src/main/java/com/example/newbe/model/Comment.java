package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "song_id",referencedColumnName="id")
    private Songs song;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName="id")
    private User user;

    @Column( length = 1000)
    private String content;


    private LocalDate timestamp;
    @ManyToOne
    @JoinColumn(name = "playlist_id", referencedColumnName = "id")
    private Playlists playlist;





}
