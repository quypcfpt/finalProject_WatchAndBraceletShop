package com.spring2019.repository;

import com.spring2019.entity.Label;
import com.spring2019.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByActive(boolean isActive, Pageable pageable);
    List<Product> findAllByActive(boolean isActive);
    Product findByIdAndActiveIsTrue(int id);
    Product findByProductCodeAndActiveIsTrue(String productCode);
    List<Product> findAllByStatusAndActiveTrue(int status);
    List<Product> findAllByActiveAndCategoryId(boolean isActive, int categoryId);
}
