package com.woodpecker.repository;

import com.woodpecker.entity.ComicEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ComicRepository extends CrudRepository <ComicEntity, Long>{

    ComicEntity findByNum(int num);
//    @Query(value = "SELECT a FROM ComicEntity a LIMIT 1", nativeQuery = true)
//    ComicEntity getRandomComic();


}
