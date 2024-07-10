package com.example.newbe.repository;

import com.example.newbe.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IAlbumRepository extends JpaRepository<Album,Integer> {

    Page<Album> findAllByTitleContaining(Pageable pageable, String name);

    List<Album> findByTitleContainingIgnoreCase(String name);


}
