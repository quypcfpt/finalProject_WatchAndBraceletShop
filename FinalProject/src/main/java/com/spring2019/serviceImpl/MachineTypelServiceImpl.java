package com.spring2019.serviceImpl;

import com.spring2019.entity.MachineType;
import com.spring2019.repository.MachineTypeRepository;
import com.spring2019.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MachineTypelServiceImpl implements MachineTypeService {

    @Autowired
    MachineTypeRepository repository;
    @Override
    public Page<MachineType>  getAllMachineTypesActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<MachineType>  getAllMachineTypes(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
