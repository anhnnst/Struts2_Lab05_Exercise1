package edu.poly.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
