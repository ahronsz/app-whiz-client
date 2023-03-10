package com.whiz.service.client.mapper;

import com.whiz.service.client.model.entity.Client;
import com.whiz.service.client.util.Util;
import com.whiz.service.client.util.constants.Format;
import com.whiz.service.expose.dto.reponse.ClientResponseDto;
import com.whiz.service.expose.dto.request.ClientRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface ClientMapper {

    @Mapping(target = "creationDateTime", expression = "java(LocalDateTime.now())")
    Client toEntity(ClientRequestDto clientRequestDto);

    ClientResponseDto toResponse(Client client);

    @AfterMapping
    default void afterMapping(Client client, @MappingTarget ClientResponseDto response) {
        Locale spanishLocale = new Locale("es", "ES");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Format.FULL_DATE, spanishLocale);
        response.setDateBirth(client.getDateBirth().format(dateTimeFormatter));
    }

    @BeforeMapping
    default void beforeMapping(Client client, @MappingTarget ClientResponseDto response) {
        Locale spanishLocale = new Locale("es", "ES");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Format.FULL_DATE, spanishLocale);

        Random gauss = new Random();
        Double probabilidad = gauss.nextGaussian() * 28.8661;
        probabilidad = Math.abs(probabilidad);
        probabilidad = Math.abs(probabilidad - 100);

        LocalDate probableDateDeath = client.getDateBirth().plusYears(probabilidad.intValue());
        response.setLastName(String.format(Format.LAST_NAME, client.getPaternalLastName(), client.getMotherLastName()));
        response.setProbableDateDeath(probableDateDeath.format(dateTimeFormatter));
        response.setProbableAgeDeath((byte) probableDateDeath.minusYears(client.getDateBirth().getYear()).getYear());
        response.setAge(Util.getYearsByLocalDate(client.getDateBirth()));
    }
}
