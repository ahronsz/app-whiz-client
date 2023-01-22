package com.whiz.service.client.repository;

import com.whiz.service.client.model.entity.User;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface UserRepository extends RxJava3CrudRepository<User, Long> {

    Maybe<User> findByEmail(String email);
}
