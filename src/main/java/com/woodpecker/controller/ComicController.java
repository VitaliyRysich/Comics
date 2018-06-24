package com.woodpecker.controller;

import com.woodpecker.entity.ComicEntity;
import com.woodpecker.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComicController {
    @Autowired
    ComicService comicService;

    @RequestMapping("/comics")
    public List<ComicEntity> getAllComics(){
        return comicService.findAll();
    }

    @RequestMapping("/comics/{id}")
    public ComicEntity getComicById(@PathVariable("id") int id){
        return comicService.getComicById(id);
    }

    @RequestMapping("/random")
    public ComicEntity getRandomComic(){
        return comicService.getRandom();
    }

    @RequestMapping (value = "/comics", method = RequestMethod.POST)
    public ComicEntity addComic(@RequestBody ComicEntity comicEntity){
        return comicService.save(comicEntity);
    }

}
