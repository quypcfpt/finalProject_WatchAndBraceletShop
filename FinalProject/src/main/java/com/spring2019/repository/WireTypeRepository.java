package com.spring2019.repository;

import com.spring2019.entity.WireType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WireTypeRepository extends JpaRepository<WireType,Integer> {
    Page<WireType> findAllByActive(boolean isActive, Pageable pageable);
    List<WireType> findAllByActive(boolean isActive);
    WireType findByNameAndActiveTrue(String name);
    WireType findById(int id);
}
