package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public interface ProductController {
    @GetMapping(CoreConstant.API_PRODUCT + "/active")
    String loadAllProductActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);

    @GetMapping(CoreConstant.API_PRODUCT)
    String loadAllProduct(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                          @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                          @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
}
