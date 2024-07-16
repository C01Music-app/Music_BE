package com.example.newbe.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String imgSongs ;

    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Artists> artist;

    private String description;
    private String time;
    private LocalDate dateStart;

    @Column(columnDefinition = "text")
    private String lyrics;

    private Integer listens;
    private Integer likes;
    private String lableSong;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Playlists> playlists;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgSongs() {
        return imgSongs;
    }

    public void setImgSongs(String imgSongs) {
        this.imgSongs = imgSongs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Artists> getArtist() {
        return artist;
    }

    public void setArtist(Set<Artists> artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Integer getListens() {
        return listens;
    }

    public void setListens(Integer listens) {
        this.listens = listens;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getLableSong() {
        return lableSong;
    }

    public void setLableSong(String lableSong) {
        this.lableSong = lableSong;
    }

    public Set<Playlists> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlists> playlists) {
        this.playlists = playlists;
    }
}
