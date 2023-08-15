package com.hami.springbootexamples.service.impl;

import com.hami.springbootexamples.dal.entity.User;
import com.hami.springbootexamples.dal.entity.repository.UserRepository;
import com.hami.springbootexamples.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
}
