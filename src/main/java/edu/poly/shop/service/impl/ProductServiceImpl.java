package edu.poly.shop.service.impl;

import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.ProductRepository;
import edu.poly.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public <S extends Product> S save(S s) {
        return productRepository.save(s);
    }

    @Override
    public <S extends Product> Iterable<S> save(Iterable<S> iterable) {
        return productRepository.save(iterable);
    }

    @Override
    @Transactional
    public Product findOne(Long aLong) {
        return productRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return productRepository.exists(aLong);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> findAll(Iterable<Long> iterable) {
        return productRepository.findAll(iterable);
    }

    @Override
    public List<Product> findProductsByName(String name){
        return productRepository.findProductsByNameLike("%" + name + "%");
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void delete(Long aLong) {
        productRepository.delete(aLong);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void delete(Iterable<? extends Product> iterable) {
        productRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
