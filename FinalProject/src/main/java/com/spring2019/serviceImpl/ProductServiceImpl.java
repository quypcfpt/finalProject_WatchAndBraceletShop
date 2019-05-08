package com.spring2019.serviceImpl;

import com.spring2019.entity.Product;
import com.spring2019.repository.ProductRepository;
import com.spring2019.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;
    @Override
    public Page<Product>  getAllProductsActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Product>  getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Product> getAllProductList() {
        return repository.findAllByActive(true);
    }

    @Override
    public boolean save(Product product) {
        Product found = repository.findByNameAndActiveIsTrue(product.getName());
        if (found != null && !(found.getId().equals(product.getId()))) {
            return false;
        }
        repository.save(product);
        return true;
    }

    @Override
    public Product getProductById(int id) {
        return repository.findByIdAndActiveIsTrue(id);
    }

    @Override
    public void delete(int id) {
        Product entity = repository.findByIdAndActiveIsTrue(id);
        if (entity != null) {
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public void updateStatus(int id) {
        Product entity = repository.findByIdAndActiveIsTrue(id);
        if (entity != null) {
            if (entity.getStatus() == 0) {
                entity.setStatus(1);
            } else {
                entity.setStatus(0);
            }
            repository.save(entity);
        }
    }

    @Override
    public List<Product> getAllProductActiveByCategoryId(int categoryId) {
        return repository.findAllByActiveAndCategoryId(true, categoryId);
    }

    @Override
    public List<Product> getAllProductsActive() {
        return repository.findAllByActive(true);
    }
}
