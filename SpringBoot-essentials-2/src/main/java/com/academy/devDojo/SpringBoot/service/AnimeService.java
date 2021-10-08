package com.academy.devDojo.SpringBoot.service;

import com.academy.devDojo.SpringBoot.domain.Anime;
import com.academy.devDojo.SpringBoot.dtos.AnimePostRequestBody;
import com.academy.devDojo.SpringBoot.dtos.AnimePutRequestBody;
import com.academy.devDojo.SpringBoot.exception.BadRequestException;
import com.academy.devDojo.SpringBoot.mapper.AnimeMapper;
import com.academy.devDojo.SpringBoot.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException( "Anime não encontrado"));
    }

    @Transactional
    public Anime save(  AnimePostRequestBody animePostRequestBody) {
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        return animeRepository.save(anime);
    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));

    }

    public void replace(  AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);

    }
}
