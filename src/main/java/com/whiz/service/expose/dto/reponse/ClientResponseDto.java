package com.whiz.service.expose.dto.reponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientResponseDto {
    private String name;
    private String lastName;
    private Byte age;
    private String dateBirth;
    private LocalDate probableDateDeath;
    private String creationDateTime;
}
