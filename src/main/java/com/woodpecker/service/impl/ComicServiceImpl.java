package com.woodpecker.service.impl;

import com.woodpecker.entity.ComicEntity;
import com.woodpecker.repository.ComicRepository;
import com.woodpecker.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {
    @Autowired
    private ComicRepository comicRepository;

    public ComicEntity save(ComicEntity comicEntity) {
        return comicRepository.save(comicEntity);
    }

    @Override
    public List<ComicEntity> findAll() {
        return (List<ComicEntity>) comicRepository.findAll();
    }

    @Override
    public ComicEntity getRandom() {
        List<ComicEntity> comicEntityList = findAll();
        int index = (int) (Math.random() * comicEntityList.size());
        return comicEntityList.get(index);
    }

    @Override
    public ComicEntity getComicById(int id) {
        return comicRepository.findByNum(id);
    }
}
