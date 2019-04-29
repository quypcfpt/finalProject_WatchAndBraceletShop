package com.spring2019.serviceImpl;

import com.spring2019.entity.ProductCategory;
import com.spring2019.repository.ProductCategoryRepository;
import com.spring2019.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository repository;
    @Override
    public Page<ProductCategory>  getAllProductCategorysActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<ProductCategory>  getAllProductCategorys(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
