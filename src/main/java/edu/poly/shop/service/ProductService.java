package edu.poly.shop.service;

import edu.poly.shop.domain.Product;

import java.util.List;

public interface ProductService {
    <S extends Product> S save(S s);

    <S extends Product> Iterable<S> save(Iterable<S> iterable);

    Product findOne(Long aLong);

    boolean exists(Long aLong);

    Iterable<Product> findAll();

    Iterable<Product> findAll(Iterable<Long> iterable);

    List<Product> findProductsByName(String name);

    long count();

    void delete(Long aLong);

    void delete(Product product);

    void delete(Iterable<? extends Product> iterable);

    void deleteAll();
}
