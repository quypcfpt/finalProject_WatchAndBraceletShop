package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.*;

public interface OrderDetailController {

    @GetMapping(CoreConstant.API_ORDERDETAIL)
    String loadAllOrderDetail(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_ORDERDETAIL+"/{id}")
    String loadOrderDetailById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_ORDERDETAIL+"/delete/{id}")
    String updateOrderDetailById(@PathVariable("id") int id);
}
