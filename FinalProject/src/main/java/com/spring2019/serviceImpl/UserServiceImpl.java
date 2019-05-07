package com.spring2019.serviceImpl;

import com.spring2019.entity.User;
import com.spring2019.repository.UserRepository;
import com.spring2019.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public Page<User>  getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<User> getAll() {
        List<User> user = repository.findAll();
        return repository.findAll();
    }

    @Override
    public void updateStatus(int id) {
        User entity = repository.findById(id);
        if (entity != null) {
            if (entity.getStatus() == 0) {
                entity.setStatus(1);
            } else {
                entity.setStatus(0);
            }
            repository.save(entity);
        }
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean save(User user) {
        User found = repository.findById((int)user.getId());
        repository.save(user);
        return true;
    }

    @Override
    public User getAccountByUsernameAndIsAdmin(String username, String password) {
        User account = repository.findByUsernameAndPasswordAndRoleId(username, password, 1);
        return account;
    }

    @Override
    public User getAccountByUsernameAndIsUse(String username, String password) {
        User account = repository.findByUsernameAndPasswordAndRoleId(username, password, 2);
        return account;
    }
}
