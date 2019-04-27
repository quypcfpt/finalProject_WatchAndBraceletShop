package com.spring2019.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/portal/user")
public interface UserController {
    @GetMapping("/index")
    public ModelAndView homePage(HttpSession session);
}
