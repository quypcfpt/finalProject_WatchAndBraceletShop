package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.*;

public interface OrderController {
    @GetMapping(CoreConstant.API_ORDER)
    String loadAllOrder(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_ORDER+"/{id}")
    String loadOrderById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_ORDER+"/delete/{id}")
    String deleteOrderById(@PathVariable("id") int id);
    @PutMapping(CoreConstant.API_ORDER+"/updatestatus/{id}")
    String updateOrderById(@PathVariable("id") int id);
}
