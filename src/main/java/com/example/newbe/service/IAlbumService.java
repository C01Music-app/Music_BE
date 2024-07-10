package com.example.newbe.service;

import com.example.newbe.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAlbumService {
    List<Album> getAll();

    Album findById(Integer id);


    void save(Album album);

    void remove(Album album);


    Page<Album> getAllPage(Pageable pageable, String name);


    List<Album> findAlbumsByName(String name);

}
