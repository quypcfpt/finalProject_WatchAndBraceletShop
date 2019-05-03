package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface MachineTypeController {
    @GetMapping(CoreConstant.API_MACHINETYPE+"/active")
    String loadAllMachineTypeActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                              @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_MACHINETYPE)
    String loadAllMachineType(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_MACHINETYPE+"/admin")
    String loadAllMachineTypesAdmin();
    @GetMapping(CoreConstant.API_MACHINETYPE+"/{id}")
    String loadMachineTypeById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_MACHINETYPE+"/delete/{id}")
    String deleteMachineTypeById(@PathVariable("id") int id);
}
