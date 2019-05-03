package com.spring2019.serviceImpl;

import com.spring2019.entity.WireType;
import com.spring2019.repository.WireTypeRepository;
import com.spring2019.service.WireTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WireTypeServiceImpl implements WireTypeService {

    @Autowired
    WireTypeRepository repository;

    @Override
    public Page<WireType> getAllWireTypesActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<WireType> getAllWireTypes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<WireType> getAllWireTypesAdmin() {

        return repository.findAllByActive(true);
    }

    @Override
    public boolean save(WireType wireType) {

        WireType found = repository.findByNameAndActiveTrue(wireType.getName());
        if (found != null && !(found.getId().equals(wireType.getId()))) {
            return false;
        }
        repository.save(wireType);
        return true;
    }


    @Override
    public void delete(int id) {
        WireType entity = repository.findById(id);
        if (entity != null) {
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public WireType getWireTypeById(int id) {
        return repository.findById(id);
    }


}
