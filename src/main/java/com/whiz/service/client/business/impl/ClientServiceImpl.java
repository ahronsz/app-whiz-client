package com.whiz.service.client.business.impl;

import com.whiz.service.client.business.ClientService;
import com.whiz.service.client.mapper.ClientMapper;
import com.whiz.service.client.model.entity.Client;
import com.whiz.service.client.repository.ClientRepository;
import com.whiz.service.client.util.Util;
import com.whiz.service.expose.dto.reponse.ClientResponseDto;
import com.whiz.service.expose.dto.reponse.KpiClientResponseDto;
import com.whiz.service.expose.dto.request.ClientRequestDto;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public Completable create(ClientRequestDto clientRequestDto) {
        return clientRepository.save(mapper.toEntity(clientRequestDto)).ignoreElement();
    }

    @Override
    public Flowable<ClientResponseDto> getAll() {
        return list().map(mapper::toResponse);
    }

    @Override
    public Single<KpiClientResponseDto> getKpi() {
        return list()
                .map(client -> Util.getYearsByLocalDate(client.getDateBirth()))
                .sorted()
                .toList()
                .map(this::calculateStandardDeviation);
    }

    @Override
    public Flowable<Client> list() {
        return clientRepository.findAll();
    }

    // Calcula la desviación estándar población
    private KpiClientResponseDto calculateStandardDeviation(List<Byte> byteList) {
        Double average = byteList.stream().mapToDouble(Byte::intValue).sum() / byteList.size();
        double standardDeviation = 0.0;

        for (Double num : byteList.stream().mapToDouble(Byte::intValue).toArray()) {
            standardDeviation += Math.pow(num - average, 2);
        }

        return KpiClientResponseDto.builder()
                .averageAge(average)
                .standardDeviation(Math.sqrt(standardDeviation / byteList.size())).build();
    }
}
