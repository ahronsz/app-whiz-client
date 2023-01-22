package com.whiz.service.expose.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class ClientRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String motherLastName;
    @NotNull
    private String paternalLastName;
    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Ingrese un formato correcto de fecha yyyy-mm-dd")
    private LocalDate dateBirth;
}
