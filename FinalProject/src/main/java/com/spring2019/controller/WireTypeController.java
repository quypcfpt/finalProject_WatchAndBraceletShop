package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface WireTypeController {
    @GetMapping(CoreConstant.API_WIRETYPE+"/active")
    String loadAllWireTypeActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                              @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_WIRETYPE)
    String loadAllWireType(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_WIRETYPE+"/admin")
    String loadAllWireTypesAdmin();
    @GetMapping(CoreConstant.API_WIRETYPE+"/{id}")
    String loadWireTypeById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_WIRETYPE+"/delete/{id}")
    String deleteWireTypeById(@PathVariable("id") int id);
}
