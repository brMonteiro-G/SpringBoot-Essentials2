package com.academy.devDojo.SpringBoot.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // gets + sets + toString + hashCode
@AllArgsConstructor
public class Anime {

    private Long id;

    private String name;
}