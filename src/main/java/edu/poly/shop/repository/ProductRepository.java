package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    @EntityGraph("productGraph")
    Product findOne(Long aLong);

    @EntityGraph("productGraph")
    List<Product> findProductsByNameLike(String name);
}
