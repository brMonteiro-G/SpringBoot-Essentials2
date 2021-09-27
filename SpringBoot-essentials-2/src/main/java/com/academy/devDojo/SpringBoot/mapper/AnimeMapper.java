package com.academy.devDojo.SpringBoot.mapper;

import com.academy.devDojo.SpringBoot.domain.Anime;
import com.academy.devDojo.SpringBoot.dtos.AnimePostRequestBody;
import com.academy.devDojo.SpringBoot.dtos.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePuttRequestBody);


}
