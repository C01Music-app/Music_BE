package com.example.newbe.repository.playlistsRepository;


import com.example.newbe.model.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaylistsRepository extends JpaRepository<Playlists, Integer> {

//    @Query(value = " select * from artists where name like :name",
//            nativeQuery = true)
//    Page<Playlists> findByNamePage(Pageable pageable,@Param("name") String name);

    List<Playlists> findByTitleContainingIgnoreCase(String name);
}
