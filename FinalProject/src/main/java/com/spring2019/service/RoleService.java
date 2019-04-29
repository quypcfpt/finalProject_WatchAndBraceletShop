package com.spring2019.service;

import com.spring2019.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    public Page<Role> getAllRolesActive(Pageable pageable);
    public Page<Role>  getAllRoles(Pageable pageable);
}
