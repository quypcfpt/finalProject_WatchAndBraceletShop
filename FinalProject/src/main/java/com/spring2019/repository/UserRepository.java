package com.spring2019.repository;

import com.spring2019.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);
    User findByUsernameAndPasswordAndRoleId(String username,String password , int role);
    List<User> findByRoleIdAndStatus(int roleId, int status);
    List<User> findByStatus(int status);
    User findByUsername(String username);
}
