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
    ProductRepository productRepository;
    @Override
    public Page<Product> getAllCamerasActive(Pageable pageable) {
        return productRepository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Product> getAllCameras(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
