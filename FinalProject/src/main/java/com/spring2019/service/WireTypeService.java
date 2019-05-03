package com.spring2019.service;

import com.spring2019.entity.WireType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WireTypeService {
    public Page<WireType> getAllWireTypesActive(Pageable pageable);
    public Page<WireType>  getAllWireTypes(Pageable pageable);
    public List<WireType> getAllWireTypesAdmin();
    boolean save(WireType wireType);
    void delete(int id);
    WireType getWireTypeById(int id);
}
