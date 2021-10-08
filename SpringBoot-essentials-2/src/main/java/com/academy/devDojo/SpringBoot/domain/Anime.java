package com.academy.devDojo.SpringBoot.domain;


import lombok.*;

import javax.persistence.*;

@Data // gets + sets + toString + hashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}