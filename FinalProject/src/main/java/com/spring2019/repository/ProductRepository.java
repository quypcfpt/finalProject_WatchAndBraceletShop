package com.spring2019.repository;

import com.spring2019.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByActive(boolean isActive, Pageable pageable);
}
