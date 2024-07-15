package com.example.newbe.controller;

import com.example.newbe.model.Artists;
import com.example.newbe.model.Playlists;
import com.example.newbe.model.Songs;
import com.example.newbe.service.ISongsService;
import com.example.newbe.service.aristsService.IArtistsService;
import com.example.newbe.service.playlistsService.IPlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongsController {
    @Autowired
    private ISongsService iSongsService;
    @Autowired
    private IArtistsService artistsService;

    @Autowired
    private IPlaylistsService playlistsService;


//    @GetMapping("")
//    public ResponseEntity<?> showSongs(@RequestParam(defaultValue = "0") int page,
//                                       @RequestParam(defaultValue = "") String name) {
//        Pageable pageable = PageRequest.of(page, 5);
//        Page<Songs> songsList = iSongsService.getAllPage(pageable, name);
//        return new ResponseEntity<>(songsList, HttpStatus.OK);
//    }




    @GetMapping("")
    public ResponseEntity<?> AllSongs() {
        List<Artists> artists = artistsService.getAllArtists();
        List<Songs> songs = iSongsService.findAll();

        System.out.println(songs);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSongs(@RequestBody Songs songs) {
        System.out.println(songs);
        iSongsService.save(songs);
        System.out.println("ok");
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

    @GetMapping("/detail/{id}")
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

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSongs(@PathVariable Integer id, @RequestBody Songs updatedSongs) {
        Songs existingSongs = iSongsService.findById(id);

        if (existingSongs == null) {
            return new ResponseEntity<>("Song not found with id: " + id, HttpStatus.NOT_FOUND);
        }

        // Update fields from updatedSongs to existingSongs
        existingSongs.setTitle(updatedSongs.getTitle());
        existingSongs.setArtist(updatedSongs.getArtist());
        existingSongs.setDescription(updatedSongs.getDescription());
        existingSongs.setTime(updatedSongs.getTime());
        existingSongs.setDateStart(updatedSongs.getDateStart());
        existingSongs.setLyrics(updatedSongs.getLyrics());
        existingSongs.setListens(updatedSongs.getListens());
        existingSongs.setLikes(updatedSongs.getLikes());
        existingSongs.setLableSong(updatedSongs.getLableSong());
        existingSongs.setPlaylists(updatedSongs.getPlaylists());

        // Save the updated song
        iSongsService.save(existingSongs);

        return new ResponseEntity<>(existingSongs, HttpStatus.OK);
    }

    @DeleteMapping("/{songId}/playlists/{playlistId}")
    public ResponseEntity<?> removePlaylistFromSong(@PathVariable Integer songId, @PathVariable Integer playlistId) {
        try {
            iSongsService.removePlaylistFromSong(songId, playlistId);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

}