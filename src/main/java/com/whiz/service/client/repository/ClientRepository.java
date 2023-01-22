package com.whiz.service.client.repository;

import com.whiz.service.client.model.entity.Client;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface ClientRepository extends RxJava3CrudRepository<Client, Long> {
}
