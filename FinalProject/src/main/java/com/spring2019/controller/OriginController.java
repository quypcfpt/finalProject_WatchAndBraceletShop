package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OriginController {
    @GetMapping(CoreConstant.API_PRODUCT+"/active")
    String loadAllOriginActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                              @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_PRODUCT)
    String loadAllOrigin(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
}
