package com.woodpecker.service;

import com.woodpecker.entity.ComicEntity;

import java.util.List;

public interface ComicService {
    ComicEntity save(ComicEntity comicEntity);
    List<ComicEntity> findAll();
    ComicEntity getRandom();
    ComicEntity getComicById(int id);

}
