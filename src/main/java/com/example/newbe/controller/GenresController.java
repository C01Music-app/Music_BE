package com.example.newbe.controller;


import com.example.newbe.model.Genres;
import com.example.newbe.service.genresService.IGenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private IGenresService genresService;

    // Hiển thị tất cả thể loại
    @GetMapping("")
    public ResponseEntity<List<Genres>> getAllGenres() {
        List<Genres> genres = genresService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    // Thêm thể loại mới
    @PostMapping("/create")
    public ResponseEntity<Genres> createGenre(@RequestBody Genres genre) {
        Genres savedGenre = genresService.saveGenre(genre);
        return ResponseEntity.ok(savedGenre);
    }

    // Xóa thể loại theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Integer id) {
        Optional<Genres> genre = genresService.getGenreById(id);
        if (genre.isPresent()) {
            genresService.deleteGenre(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm kiếm thể loại theo tên
    @GetMapping("/search")
    public ResponseEntity<List<Genres>> searchGenresByName(@RequestParam String name) {
        List<Genres> genres = genresService.findGenresByName(name);
        return ResponseEntity.ok(genres);
    }

    // Lấy chi tiết thể loại theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Genres> getGenreById(@PathVariable Integer id) {
        Optional<Genres> genre = genresService.getGenreById(id);
        if (genre.isPresent()) {
            return ResponseEntity.ok(genre.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
