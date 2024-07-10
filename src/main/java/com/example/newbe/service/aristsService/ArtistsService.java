package com.example.newbe.service.aristsService;

import com.example.newbe.model.Artists;
import com.example.newbe.repository.artistsRepository.IArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistsService implements IArtistsService {

    @Autowired
    private IArtistsRepository artistsRepository;

    @Override
    public Artists saveArtist(Artists artist) {
        return artistsRepository.save(artist);
    }

    @Override
    public List<Artists> getAllArtists() {
        return artistsRepository.findAll();
    }

    @Override
    public Artists getArtistById(Integer id) {
        return artistsRepository.findById(id).get();
    }



    @Override
    public void deleteArtist(Integer id) {
        artistsRepository.deleteById(id);
    }

    @Override
    public List<Artists> findArtistsByName(String name) {
        return artistsRepository.findByNameContainingIgnoreCase(name);
    }
}
