package com.spring2019.serviceImpl;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Product;
import com.spring2019.entity.ProductCategory;
import com.spring2019.repository.GlassTypeRepository;
import com.spring2019.repository.ProductRepository;
import com.spring2019.service.GlassTypeService;
import com.spring2019.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlassTypeServiceImpl implements GlassTypeService {

    @Autowired
    GlassTypeRepository repository;

    @Override
    public Page<GlassType> getAllGlassTypesActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public List<GlassType> getAllGlassTypes() {
        return repository.findAllByActive(true);
    }

    @Override
    public boolean save(GlassType glassType) {
        GlassType found = repository.findByNameAndActiveIsTrue(glassType.getName());
        if (found != null && !(found.getId().equals(glassType.getId()))) {
            return false;
        }
        repository.save(glassType);
        return true;
    }

    @Override
    public GlassType getGlassTypeById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        GlassType entity = repository.findById(id);
        if (entity != null) {
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public void updateStatus(int id) {
        GlassType entity = repository.findById(id);
        if (entity != null) {
            if (entity.getStatus() == 1) {
                entity.setStatus(2);
            } else {
                entity.setStatus(1);
            }
            repository.save(entity);
        }
    }
}
