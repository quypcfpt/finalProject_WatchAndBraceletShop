package com.spring2019.service;

import com.spring2019.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCategoryService {
    public Page<ProductCategory> getAllProductCategorysActive(Pageable pageable);
    public Page<ProductCategory>  getAllProductCategorys(Pageable pageable);
    public List<ProductCategory> getAllProductCategorysAdmin();
    void save(ProductCategory category);
    ProductCategory getProductCategoryById(int id);
    void delete(int id);
    void updateStatus(int id);
}
