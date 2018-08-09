package edu.poly.shop.service.impl;

import edu.poly.shop.domain.User;
import edu.poly.shop.repository.UserRepository;
import edu.poly.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public <S extends User> S save(S s) {
        return userRepository.save(s);
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> iterable) {
        return userRepository.save(iterable);
    }

    @Override
    public User findOne(Long aLong) {
        return userRepository.findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return userRepository.exists(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAll(Iterable<Long> iterable) {
        return userRepository.findAll(iterable);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void delete(Long aLong) {
        userRepository.delete(aLong);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(Iterable<? extends User> iterable) {
        userRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
