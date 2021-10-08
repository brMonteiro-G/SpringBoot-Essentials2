package com.academy.devDojo.SpringBoot.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {

    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime time;



}
