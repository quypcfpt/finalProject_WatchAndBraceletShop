package com.spring2019.serviceImpl;

import com.spring2019.entity.ProductCategory;
import com.spring2019.repository.ProductCategoryRepository;
import com.spring2019.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductCategory> getAllProductCategorysAdmin() {
        return repository.findAllByActive(true);
    }

    @Override
    public void save(ProductCategory category) {
       repository.save(category);
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
      return  repository.findById(id);
    }

    @Override
    public void delete(int id) {
        ProductCategory entity = repository.findById(id);
        if(entity != null){
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public void updateStatus(int id) {
        ProductCategory entity = repository.findById(id);
        if(entity != null){
            if(entity.getStatus()== 1){
                entity.setStatus(2);
            }else {
                entity.setStatus(1);
            }
            repository.save(entity);
        }
    }
}
