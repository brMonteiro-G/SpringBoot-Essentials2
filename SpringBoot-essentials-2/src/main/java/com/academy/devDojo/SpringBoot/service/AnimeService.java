package com.academy.devDojo.SpringBoot.service;

import com.academy.devDojo.SpringBoot.dtos.AnimePostRequestBody;
import com.academy.devDojo.SpringBoot.dtos.AnimePutRequestBody;
import com.academy.devDojo.SpringBoot.domain.Anime;
import com.academy.devDojo.SpringBoot.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime não encontrado"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        return animeRepository.save(anime);
    }

    public void delete(Long id) {
        animeRepository.delete(animeRepository.getById(id));

    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime anime = Anime.builder().
                name(animePutRequestBody.getName()).id(animePutRequestBody.getId()).build();

    }
}
