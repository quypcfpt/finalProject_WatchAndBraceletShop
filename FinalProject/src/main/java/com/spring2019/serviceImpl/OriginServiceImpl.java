package com.spring2019.serviceImpl;

import com.spring2019.entity.Origin;
import com.spring2019.repository.OriginRepository;
import com.spring2019.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OriginServiceImpl implements OriginService {

    @Autowired
    OriginRepository repository;
    @Override
    public Page<Origin>  getAllOriginsActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Origin>  getAllOrigins(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
