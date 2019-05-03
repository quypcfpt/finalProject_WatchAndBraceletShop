package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.UserController;
import com.spring2019.entity.User;
import com.spring2019.model.UserModel;
import com.spring2019.model.MultiUserModel;
import com.spring2019.model.Response;
import com.spring2019.repository.UserRepository;
import com.spring2019.service.UserService;
import com.spring2019.transformer.UserTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserControllerImpl extends AbstractController implements UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);
    @Override
    public ModelAndView homePage(HttpSession session) {
        return new ModelAndView("index");
    }

    // api controller
    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;

    @Autowired
    UserTransformer transformer;
    


    @Override
    public String loadAllUser(Integer page, Integer size, String sort, String sortBy) {
        return null;
    }
}
