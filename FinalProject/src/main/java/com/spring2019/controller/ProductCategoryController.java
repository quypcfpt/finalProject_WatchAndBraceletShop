package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.*;

public interface ProductCategoryController {
    @GetMapping(CoreConstant.API_PRODUCTCATEGORY + "/active")
    String loadAllProductCategoryActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);

    @GetMapping(CoreConstant.API_PRODUCTCATEGORY)
    String loadAllProductCategory(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                  @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                  @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);

    @GetMapping(CoreConstant.API_PRODUCTCATEGORY + "/admin")
    String loadAllProductCategoryAdmin();

    @GetMapping(CoreConstant.API_PRODUCTCATEGORY + "/{id}")
    String loadProductCategoryById(@PathVariable("id") int id);

    @DeleteMapping(CoreConstant.API_PRODUCTCATEGORY + "/delete/{id}")
    String deleteProductCategoryById(@PathVariable("id") int id);

    @PutMapping(CoreConstant.API_PRODUCTCATEGORY + "/updatestatus/{id}")
    String updateProductCategoryById(@PathVariable("id") int id);

    @GetMapping(CoreConstant.API_PRODUCTCATEGORY_ACTIVE)
    String getListProductCategoryActive();
}
