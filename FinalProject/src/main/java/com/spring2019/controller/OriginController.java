package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.*;

public interface OriginController {
    @GetMapping(CoreConstant.API_ORIGIN+"/active")
    String loadAllOriginActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                              @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_ORIGIN)
    String loadAllOrigin(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_ORIGIN+"/{id}")
    String loadOriginById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_ORIGIN+"/delete/{id}")
    String deleteOriginById(@PathVariable("id") int id);
    @PutMapping(CoreConstant.API_ORIGIN+"/updatestatus/{id}")
    String updateOriginById(@PathVariable("id") int id);
}
