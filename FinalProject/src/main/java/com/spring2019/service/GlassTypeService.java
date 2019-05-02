package com.spring2019.service;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GlassTypeService {
    public Page<GlassType> getAllGlassTypesActive(Pageable pageable);
    public Page<GlassType>  getAllGlassTypes(Pageable pageable);
}
