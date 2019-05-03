package com.spring2019.repository;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends JpaRepository<Label,Integer> {
    Page<Label> findAllByActive(boolean isActive, Pageable pageable);
    List<Label> findAllByActive(boolean isActive);
    Label findById(int id);
}
