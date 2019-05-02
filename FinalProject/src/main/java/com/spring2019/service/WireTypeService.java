package com.spring2019.service;

import com.spring2019.entity.WireType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WireTypeService {
    public Page<WireType> getAllWireTypesActive(Pageable pageable);
    public Page<WireType>  getAllWireTypes(Pageable pageable);
}
