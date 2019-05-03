package com.spring2019.repository;

import com.spring2019.entity.Product;
import com.spring2019.entity.GlassType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlassTypeRepository extends JpaRepository<GlassType,Integer> {
    Page<GlassType> findAllByActive(boolean isActive, Pageable pageable);
    List<GlassType> findAllByActive(boolean isActive);
    GlassType findById(int id);
}
