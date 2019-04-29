package com.spring2019.service;

import com.spring2019.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductCategoryService {
    public Page<ProductCategory> getAllProductCategorysActive(Pageable pageable);
    public Page<ProductCategory>  getAllProductCategorys(Pageable pageable);
}
