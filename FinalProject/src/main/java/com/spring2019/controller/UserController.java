package com.spring2019.controller;


import com.spring2019.common.CoreConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


public interface UserController {
    @GetMapping("/index")
    public ModelAndView homePage(HttpSession session);
    
    
    //api controller

    @GetMapping(CoreConstant.API_USER)
    String loadAllUser(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                        @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_USER+"/admin")
    String loadAllUserAdmin();
    @PutMapping(CoreConstant.API_USER+"/updatestatus/{id}")
    String updateUserById(@PathVariable("id") int id);

    @PostMapping(CoreConstant.API_USER+"/login")
    @ResponseBody
    String loginUser(@RequestParam (name = "accountModel") String accountModel, HttpSession session);
}
