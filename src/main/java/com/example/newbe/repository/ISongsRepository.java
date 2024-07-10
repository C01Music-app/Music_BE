package com.example.newbe.repository;

import com.example.newbe.model.Songs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongsRepository extends JpaRepository<Songs, Integer> {


    Page<Songs> findAllByTitleContaining(Pageable pageable, String name);

    List<Songs> findByTitleContainingIgnoreCase(String name);

    @Query(value = " SELECT * FROM songs ORDER BY date_start DESC",
            nativeQuery = true)
    List<Songs> findAllSongs();

//    SELECT id, title, release_date
//    FROM songs
//    ORDER BY release_date DESC;


}
