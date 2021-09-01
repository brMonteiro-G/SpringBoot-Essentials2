package com.academy.devDojo.SpringBoot.service;

import com.academy.devDojo.SpringBoot.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> animes =  List.of(new Anime(1L, "DBZ"), new Anime( 2L , "Naruto"));

    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(Long id){
        return animes.stream()
                .filter((anime) -> anime.getId().equals(id) )
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime não encontrado"));
    }

}
