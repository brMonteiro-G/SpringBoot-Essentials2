package com.academy.devDojo.SpringBoot.controller;

import com.academy.devDojo.SpringBoot.domain.Anime;
import com.academy.devDojo.SpringBoot.service.AnimeService;
import com.academy.devDojo.SpringBoot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor // public AnimeController(){this.dateUtil = dateUtil;} //injeção via construtor
@RequestMapping("animes") //padrão colocar plural
public class AnimeController {

    private final DateUtil dateUtil;

    private final AnimeService Animeservice;

    //http://localhost:8080/animes
    @GetMapping
    public ResponseEntity<List<Anime>> List(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(Animeservice.listAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        return ResponseEntity.ok(Animeservice.findById(id));
    }

}