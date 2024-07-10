package com.example.newbe.service.genresService;


import com.example.newbe.model.Genres;

import java.util.List;
import java.util.Optional;

public interface IGenresService {
    Genres saveGenre(Genres genre);
    List<Genres> getAllGenres();
    Optional<Genres> getGenreById(Integer id);
    void deleteGenre(Integer id);
    List<Genres> findGenresByName(String name);
}
