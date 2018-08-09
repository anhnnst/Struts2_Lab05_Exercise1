package edu.poly.shop.service;

import edu.poly.shop.domain.Category;

public interface CategoryService {

	<S extends Category> S save(S s);

	<S extends Category> Iterable<S> save(Iterable<S> iterable);

	Category findOne(Long aLong);

	boolean exists(Long aLong);

	Iterable<Category> findAll();

	Iterable<Category> findAll(Iterable<Long> iterable);

	long count();

	void delete(Long aLong);

	void delete(Category category);

	void delete(Iterable<? extends Category> iterable);

	void deleteAll();
}
