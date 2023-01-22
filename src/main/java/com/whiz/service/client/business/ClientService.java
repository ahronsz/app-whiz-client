package com.whiz.service.client.business;

import com.whiz.service.client.model.entity.Client;
import com.whiz.service.expose.dto.reponse.ClientResponseDto;
import com.whiz.service.expose.dto.reponse.KpiClientResponseDto;
import com.whiz.service.expose.dto.request.ClientRequestDto;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface ClientService {
    Completable create(ClientRequestDto clientRequestDto);

    Flowable<Client> list();

    Single<KpiClientResponseDto> getKpi();
    Flowable<ClientResponseDto> getAll();
}
