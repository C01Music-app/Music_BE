package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "song_id",referencedColumnName="id")
    private Songs song;


    @ManyToOne
    @JoinColumn(name = "playlist_id", referencedColumnName = "id")
    private Playlists playlist;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



}
