package com.spring2019.serviceImpl;

import com.spring2019.entity.Role;
import com.spring2019.repository.RoleRepository;
import com.spring2019.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;
    @Override
    public Page<Role>  getAllRolesActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Role>  getAllRoles(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
