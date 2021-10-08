package com.academy.devDojo.SpringBoot.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePutRequestBody {

    @NotNull(message = "id cannot be null" )
    private Long id;

    @NotBlank(message = "name cannot be null or empty ")
    private String name;

}
