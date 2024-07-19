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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Songs getSong() {
        return song;
    }

    public void setSong(Songs song) {
        this.song = song;
    }

    public Playlists getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlists playlist) {
        this.playlist = playlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
