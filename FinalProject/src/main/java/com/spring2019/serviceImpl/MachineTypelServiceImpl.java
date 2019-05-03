package com.spring2019.serviceImpl;

import com.spring2019.entity.MachineType;
import com.spring2019.repository.MachineTypeRepository;
import com.spring2019.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<MachineType> getAllMachineTypesAdmin() {
        return repository.findAllByActive(true);
    }

    @Override
    public boolean save(MachineType machineType) {
        MachineType found = repository.findByNameAndActiveTrue(machineType.getName());
        if (found != null && !(found.getId().equals(machineType.getId()))) {
            return false;
        }
        repository.save(machineType);
        return true;
    }

    @Override
    public void delete(int id) {
        MachineType entity = repository.findById(id);
        if (entity != null) {
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public MachineType getMachineTypeById(int id) {
        return repository.findById(id);
    }
}
