package com.spring2019.service;

import com.spring2019.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public Page<Product> getAllProductsActive(Pageable pageable);
    public Page<Product>  getAllProducts(Pageable pageable);
    public List<Product> getAllProductList();
    boolean save(Product Product);
    public Product getProductById(int id);
    void delete(int id);
    void updateStatus(int id);
    List<Product> getAllProductActiveByCategoryId(int categoryId);
    List<Product> getAllProductsActive();
}
