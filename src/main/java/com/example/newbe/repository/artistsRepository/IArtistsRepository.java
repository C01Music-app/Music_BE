package com.example.newbe.repository.artistsRepository;

import com.example.newbe.model.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArtistsRepository extends JpaRepository<Artists, Integer> {

//    @Query(value = " select * from artists where name like :name",
//            nativeQuery = true)
//    Page<Artists> findbyNamePage(Pageable pageable, @Param("name") String name);

    List<Artists> findByNameContainingIgnoreCase(String name);
}
