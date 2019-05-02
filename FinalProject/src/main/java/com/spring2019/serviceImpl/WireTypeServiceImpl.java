package com.spring2019.serviceImpl;

import com.spring2019.entity.WireType;
import com.spring2019.repository.WireTypeRepository;
import com.spring2019.service.WireTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WireTypeServiceImpl implements WireTypeService {

    @Autowired
    WireTypeRepository repository;
    @Override
    public Page<WireType>  getAllWireTypesActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<WireType>  getAllWireTypes(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
