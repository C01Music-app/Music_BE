package com.example.newbe.service.genresService;

import com.example.newbe.model.Genres;
import com.example.newbe.repository.genresRepository.IGenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService implements IGenresService {

    @Autowired
    private IGenresRepository genresRepository;

    @Override
    public Genres saveGenre(Genres genre) {
        return genresRepository.save(genre);
    }

    @Override
    public List<Genres> getAllGenres() {
        return genresRepository.findAll();
    }

    @Override
    public Optional<Genres> getGenreById(Integer id) {
        return genresRepository.findById(id);
    }

    @Override
    public void deleteGenre(Integer id) {
        genresRepository.deleteById(id);
    }

    @Override
    public List<Genres> findGenresByName(String name) {
        return genresRepository.findByNameContainingIgnoreCase(name);
    }
}
