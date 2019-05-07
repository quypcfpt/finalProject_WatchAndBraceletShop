package com.spring2019.service;

import com.spring2019.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public Page<User>  getAllUsers(Pageable pageable);
    public List<User> getAll();
    public List<User> getAllByStatusAndRole(int roleId, int status);
    public List<User> getAllByStatus(int status);
    void updateStatus(int id);
    User getUserById(int id);
    boolean save(User user);
}
