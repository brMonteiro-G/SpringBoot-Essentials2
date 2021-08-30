package com.academy.devDojo.SpringBoot.controller;

import com.academy.devDojo.SpringBoot.domain.Anime;
import com.academy.devDojo.SpringBoot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor // public AnimeController(){this.dateUtil = dateUtil;} //injeção via construtor
@RequestMapping("anime")
public class AnimeController {

    private final DateUtil dateUtil;

    //http://localhost:8080/anime/list
    @GetMapping(path="list")
    public List<Anime>  List(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"), new Anime("Naruto"));
    }

}