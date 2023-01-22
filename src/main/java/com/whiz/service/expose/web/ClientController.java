package com.whiz.service.expose.web;

import com.whiz.service.client.business.ClientService;
import com.whiz.service.expose.dto.reponse.ClientResponseDto;
import com.whiz.service.expose.dto.reponse.KpiClientResponseDto;
import com.whiz.service.expose.dto.request.ClientRequestDto;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Completable create(@RequestBody @Valid ClientRequestDto clientRequestDto) {
        return clientService.create(clientRequestDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flowable<ClientResponseDto> list() {
        return clientService.getAll();
    };

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/kpi")
    public Single<KpiClientResponseDto> kpi() {
        return clientService.getKpi();
    };
}
