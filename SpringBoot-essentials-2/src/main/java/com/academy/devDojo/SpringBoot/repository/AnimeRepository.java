package com.academy.devDojo.SpringBoot.repository;

import com.academy.devDojo.SpringBoot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
