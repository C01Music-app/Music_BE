package com.example.newbe.controller;

import com.example.newbe.model.Album;
import com.example.newbe.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private IAlbumService iAlbumService;


    @GetMapping("")
    public ResponseEntity<?> showAlbum(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Album> albumList = iAlbumService.getAllPage(pageable, name);
        return new ResponseEntity<>(albumList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> byIdAlbum(@PathVariable Integer id) {
        Album album = iAlbumService.findById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createAlbum(@RequestBody Album album) {
        iAlbumService.save(album);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAlbum(@RequestBody Album album, @PathVariable Integer id) {
//        List<Album> albumList = iAlbumService.getAll();
//        for (int i = 0; i < albumList.size(); i++) {
//            if(albumList.get(i).getId().equals(id)){
//
//            }
//        }
//        Album album = iAlbumService.findById(id);
        iAlbumService.save(album);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("Remove/{id}")
    public ResponseEntity<?> removeAlbum(@PathVariable Integer id) {
        Album album = iAlbumService.findById(id);
        iAlbumService.remove(album);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchArtistsByName(@RequestParam String name) {
        List<Album> albums = iAlbumService.findAlbumsByName(name);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

}
