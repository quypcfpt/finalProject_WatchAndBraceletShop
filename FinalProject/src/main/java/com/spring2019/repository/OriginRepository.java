package com.spring2019.repository;

import com.spring2019.entity.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OriginRepository extends JpaRepository<Origin,Integer> {
    Page<Origin> findAllByActive(boolean isActive, Pageable pageable);
    List<Origin> findAllByActive(boolean isActive);
    Origin findById(int id);
    Origin findByNameAndActiveIsTrue(String name);
}
