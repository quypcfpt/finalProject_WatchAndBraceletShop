package com.spring2019.serviceImpl;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Product;
import com.spring2019.repository.GlassTypeRepository;
import com.spring2019.repository.ProductRepository;
import com.spring2019.service.GlassTypeService;
import com.spring2019.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GlassTypeServiceImpl implements GlassTypeService {

    @Autowired
    GlassTypeRepository repository;
    @Override
    public Page<GlassType>  getAllGlassTypesActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<GlassType>  getAllGlassTypes(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
