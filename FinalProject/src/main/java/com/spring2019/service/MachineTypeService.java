package com.spring2019.service;

import com.spring2019.entity.MachineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MachineTypeService {
    public Page<MachineType> getAllMachineTypesActive(Pageable pageable);
    public Page<MachineType>  getAllMachineTypes(Pageable pageable);
    public List<MachineType> getAllMachineTypesAdmin();
    boolean save(MachineType machineType);
    void delete(int id);
    MachineType getMachineTypeById(int id);
}
