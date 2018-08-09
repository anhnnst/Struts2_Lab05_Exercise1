package edu.poly.shop.service;

import edu.poly.shop.domain.User;

import java.util.Optional;

public interface UserService {
    <S extends User> S save(S s);

    <S extends User> Iterable<S> save(Iterable<S> iterable);

    User findOne(Long aLong);

    boolean exists(Long aLong);

    Iterable<User> findAll();

    Iterable<User> findAll(Iterable<Long> iterable);

    Optional<User> findByUsername(String username);

    long count();

    void delete(Long aLong);

    void delete(User user);

    void delete(Iterable<? extends User> iterable);

    void deleteAll();
}
