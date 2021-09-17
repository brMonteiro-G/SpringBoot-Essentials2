package com.academy.devDojo.SpringBoot.controller;

import com.academy.devDojo.SpringBoot.dtos.AnimePostRequestBody;
import com.academy.devDojo.SpringBoot.dtos.AnimePutRequestBody;
import com.academy.devDojo.SpringBoot.domain.Anime;
import com.academy.devDojo.SpringBoot.service.AnimeService;
import com.academy.devDojo.SpringBoot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor // public AnimeController(){this.dateUtil = dateUtil;} //injeção via construtor
@RequestMapping("animes") //padrão colocar plural
public class AnimeController {

    private final DateUtil dateUtil;

    private final AnimeService animeservice;

    //http://localhost:8080/animes
    @GetMapping
    public ResponseEntity<List<Anime>> List() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeservice.listAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animeservice.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animeservice.save(animePostRequestBody));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animeservice.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeservice.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}