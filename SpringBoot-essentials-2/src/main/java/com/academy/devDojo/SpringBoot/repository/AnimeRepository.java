package com.academy.devDojo.SpringBoot.repository;

import com.academy.devDojo.SpringBoot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
