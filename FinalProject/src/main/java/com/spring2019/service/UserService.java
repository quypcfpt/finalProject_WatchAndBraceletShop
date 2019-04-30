package com.spring2019.service;

import com.spring2019.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public Page<User>  getAllUsers(Pageable pageable);
}
