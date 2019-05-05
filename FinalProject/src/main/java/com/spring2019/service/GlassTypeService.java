package com.spring2019.service;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Product;
import com.spring2019.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GlassTypeService {
    public Page<GlassType> getAllGlassTypesActive(Pageable pageable);
    public List<GlassType> getAllGlassTypes();
    boolean save(GlassType glassType);
    public GlassType getGlassTypeById(int id);
    void delete(int id);
    void updateStatus(int id);
}
