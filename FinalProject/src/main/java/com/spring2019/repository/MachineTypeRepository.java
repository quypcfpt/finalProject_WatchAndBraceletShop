package com.spring2019.repository;

import com.spring2019.entity.Label;
import com.spring2019.entity.MachineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineTypeRepository extends JpaRepository<MachineType,Integer> {
    Page<MachineType> findAllByActive(boolean isActive, Pageable pageable);
    List<MachineType> findAllByActive(boolean isActive);
    MachineType findByNameAndActiveTrue(String name);
    MachineType findById(int id);
}
