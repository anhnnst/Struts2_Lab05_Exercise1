package edu.poly.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.repository.CategoryRepository;
import edu.poly.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public <S extends Category> S save(S s) {
		return categoryRepository.save(s);
	}

	@Override
	public <S extends Category> Iterable<S> save(Iterable<S> iterable) {
		return categoryRepository.save(iterable);
	}

	@Override
	public Category findOne(Long aLong) {
		return categoryRepository.findOne(aLong);
	}

	@Override
	public boolean exists(Long aLong) {
		return categoryRepository.exists(aLong);
	}

	@Override
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Iterable<Category> findAll(Iterable<Long> iterable) {
		return categoryRepository.findAll(iterable);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void delete(Long aLong) {
		categoryRepository.delete(aLong);
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void delete(Iterable<? extends Category> iterable) {
		categoryRepository.delete(iterable);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
}
