package com.spring2019.service;

import com.spring2019.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Page<Product> getAllCamerasActive(Pageable pageable);
    public Page<Product> getAllCameras(Pageable pageable);
}
