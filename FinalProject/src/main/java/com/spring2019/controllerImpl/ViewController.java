package com.spring2019.controllerImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    /**
     * Login Page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/login", "/"})
    public String toLogin(Model model) {
        return "admin/index";
    }

    /**
     * Home Product Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/home")
    public String toHome(Model model) {
        //Excute anything here
        return "product/home";
    }

    /**
     * Home Product Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/watch")
    public String toWatch(Model model) {
        //Excute anything here
        return "product/watch";
    }
}
