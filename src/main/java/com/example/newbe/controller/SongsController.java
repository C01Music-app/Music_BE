package com.example.newbe.controller;

import com.example.newbe.model.Songs;
import com.example.newbe.service.ISongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/songs")
public class SongsController {
    @Autowired
    private ISongsService iSongsService;

//    @GetMapping("")
//    public ResponseEntity<?> showSongs(@RequestParam(defaultValue = "0") int page,
//                                       @RequestParam(defaultValue = "") String name) {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<Songs> songsList = iSongsService.getAllPage(pageable, name);
//        return new ResponseEntity<>(songsList, HttpStatus.OK);
//    }


    @GetMapping("")
    public ResponseEntity<?> AllSongs() {
        List<Songs> songs = iSongsService.findAll();
        System.out.println(songs);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSongs(@RequestBody Songs songs) {
        iSongsService.save(songs);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ByIdSongs(@PathVariable Integer id) {
        Songs songs = iSongsService.findById(id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> removesSongs(@PathVariable Integer id) {
        Songs songs = iSongsService.findById(id);
        iSongsService.removeSongs(songs);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<?> detailSongs(@PathVariable Integer id) {
        Songs songs = iSongsService.findById(id);
        iSongsService.detail(songs);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchArtistsByName(@RequestParam String name) {
        List<Songs> songsList = iSongsService.findSongsByName(name);
        return new ResponseEntity<>(songsList, HttpStatus.OK);
    }

}