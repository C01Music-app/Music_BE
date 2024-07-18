package com.example.newbe.controller;

import com.example.newbe.model.Comment;
import com.example.newbe.model.Likes;
import com.example.newbe.model.Playlists;
import com.example.newbe.service.likeService.ILikeService;
import com.example.newbe.service.playlistsService.IPlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistsController {

    @Autowired
    private IPlaylistsService playlistsService;
    @Autowired
    private ILikeService likeService;



    // Hiển thị tất cả danh sách phát
    @GetMapping("")
    public ResponseEntity<List<Playlists>> getAllPlaylists() {
        List<Playlists> playlists = playlistsService.getAllPlaylists();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    // Tạo danh sách phát mới
    @PostMapping("/create")
    public ResponseEntity<Playlists> createPlaylist(@RequestBody Playlists playlist) {
        Playlists savedPlaylist = playlistsService.savePlaylist(playlist);
        return new ResponseEntity<>(savedPlaylist, HttpStatus.CREATED);
    }

    // Lấy danh sách phát theo ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Playlists> getPlaylistById(@PathVariable Integer id) {
        Optional<Playlists> playlist = playlistsService.getPlaylistById(id);
        if (playlist.isPresent()) {
            return new ResponseEntity<>(playlist.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Xóa danh sách phát theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Integer id) {
        Optional<Playlists> playlist = playlistsService.getPlaylistById(id);
        if (playlist.isPresent()) {
            playlistsService.deletePlaylist(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Tìm kiếm danh sách phát theo tên
    @GetMapping("/search")
    public ResponseEntity<List<Playlists>> searchPlayListByName(@RequestParam String name) {
        List<Playlists> playlists = playlistsService.findPlayListByName(name);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    // Chỉnh sửa danh sách phát theo ID
    @PutMapping("/edit/{id}")
    public ResponseEntity<Playlists> editPlaylist(@PathVariable Integer id, @RequestBody Playlists playlistDetails) {
        Optional<Playlists> optionalPlaylist = playlistsService.getPlaylistById(id);
        if (optionalPlaylist.isPresent()) {
            Playlists playlist = optionalPlaylist.get();
            playlist.setTitle(playlistDetails.getTitle());
            // Cập nhật các trường thông tin khác của playlist nếu cần thiết

            Playlists updatedPlaylist = playlistsService.savePlaylist(playlist);
            return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}/like")
    public ResponseEntity<Likes> likePlaylist(@PathVariable Integer id, @RequestBody Likes like) {
        return ResponseEntity.ok(playlistsService.likePlaylist(id, like));
    }


}
