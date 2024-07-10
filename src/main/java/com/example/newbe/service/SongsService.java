package com.example.newbe.service;

import com.example.newbe.model.Songs;
import com.example.newbe.repository.ISongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService implements ISongsService {
    @Autowired
    private ISongsRepository iSongsRepository;


    @Override
    public Page<Songs> getAllPage(Pageable pageable, String name) {
        return iSongsRepository.findAll(pageable);
    }

    @Override
    public void save(Songs songs) {
        iSongsRepository.save(songs);
    }

    @Override
    public Songs findById(Integer id) {
        return iSongsRepository.findById(id).get();
    }

    @Override
    public void removeSongs(Songs songs) {
        iSongsRepository.delete(songs);
    }

    @Override
    public void detail(Songs songs) {
        iSongsRepository.findById(songs.getId());
    }

    @Override
    public List<Songs> findSongsByName(String name) {
        return iSongsRepository.findByTitleContainingIgnoreCase(name);
    }

    @Override
    public List<Songs> findAll() {
        return iSongsRepository.findAllSongs();
    }


}
