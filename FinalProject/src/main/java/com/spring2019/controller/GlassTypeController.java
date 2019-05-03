package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.*;

public interface GlassTypeController {
    @GetMapping(CoreConstant.API_GLASSTYPE+"/active")
    String loadAllGlassTypeActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_GLASSTYPE)
    String loadAllGlassType(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                          @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                          @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_GLASSTYPE+"/{id}")
    String loadGlassTypeById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_GLASSTYPE+"/delete/{id}")
    String deleteGlassTypeById(@PathVariable("id") int id);
    @PutMapping(CoreConstant.API_GLASSTYPE+"/updatestatus/{id}")
    String updateGlassTypeById(@PathVariable("id") int id);
}
