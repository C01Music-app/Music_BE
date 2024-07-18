package com.example.newbe.service.aristsService;

import com.example.newbe.model.Album;
import com.example.newbe.model.Artists;

import java.util.List;

public interface IArtistsService {
    Artists saveArtist(Artists artist);

    List<Artists> getAllArtists();



    Artists getArtistById(Integer id);

    
    void deleteArtist(Integer id);

    List<Artists> findArtistsByName(String name);


    Artists updateArtist(Integer id, Artists artist);


//    Page<Artists> findArtistsByName(Pageable pageable, String name);

}
