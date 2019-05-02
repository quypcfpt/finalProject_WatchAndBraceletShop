package com.spring2019.serviceImpl;

import com.spring2019.entity.User;
import com.spring2019.repository.UserRepository;
import com.spring2019.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public Page<User>  getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
