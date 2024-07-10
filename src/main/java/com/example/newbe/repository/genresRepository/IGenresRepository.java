package com.example.newbe.repository.genresRepository;

import com.example.newbe.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGenresRepository extends JpaRepository<Genres, Integer> {
    List<Genres> findByNameContainingIgnoreCase(String name);
}
