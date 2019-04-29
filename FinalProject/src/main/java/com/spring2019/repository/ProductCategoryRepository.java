package com.spring2019.repository;

import com.spring2019.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    Page<ProductCategory> findAllByActive(boolean isActive, Pageable pageable);
}
