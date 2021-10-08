package com.academy.devDojo.SpringBoot.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class AnimePostRequestBody {

    @NotBlank(message = "name cannot be null or empty")
    private String name;
}
