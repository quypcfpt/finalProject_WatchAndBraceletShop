package com.spring2019.controllerImpl;

import com.spring2019.controller.UserController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public class UserControllerImpl extends AbstractController implements UserController {
    @Override
    public ModelAndView homePage(HttpSession session) {
        return new ModelAndView("index");
    }
}
