package com.example.newbe.controller;


import com.example.newbe.model.Artists;
import com.example.newbe.service.aristsService.IArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/artists")
public class ArtistsController {

    @Autowired
    private IArtistsService artistsService;

    // Hiển thị tất cả nghệ sĩ
    @GetMapping("")
    public ResponseEntity<List<Artists>> getAllArtists() {
        List<Artists> artists = artistsService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    // Tạo nghệ sĩ mới
    @PostMapping("/create")
    public ResponseEntity<Artists> createArtist(@RequestBody Artists artist) {
        Artists savedArtist = artistsService.saveArtist(artist);
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }


    // Lấy nghệ sĩ theo ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Artists> getArtistById(@PathVariable Integer id) {
        Artists artist = artistsService.getArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    // Xóa nghệ sĩ theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Integer id) {
        artistsService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Artists>> searchArtistsByName(@RequestParam String name) {
        List<Artists> artists = artistsService.findArtistsByName(name);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}
