//package com.spring2019.controllerImpl;
//
//import com.spring2019.controller.AdminController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class AdminControllerImpl extends AbstractController implements AdminController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(AdminControllerImpl.class);
//
//    //process login page request
//    @Override
//    public ModelAndView openLogin(HttpSession session) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            return new ModelAndView("redirect:/portal/camera");
//        } else {
//            return new ModelAndView("login");
//        }
//    }
//
//    @Override
//    public ModelAndView openIndex(HttpSession session) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            return new ModelAndView("tables");
//        } else {
//            return new ModelAndView("redirect:/portal/login");
//        }
//    }
//
//    //process street page request
//    @Override
//    public ModelAndView openStreet(HttpSession session) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            return new ModelAndView("street_tables");
//        } else {
//            return new ModelAndView("redirect:/portal/login");
//        }
//    }
//
//    //process log out request
//    public ModelAndView logout(HttpSession session) {
//        session.removeAttribute("username");
//        LOGGER.info("Admin account logged out");
//        return new ModelAndView("redirect:/portal/login");
//    }
//
//    @Override
//    public ModelAndView report(HttpSession session) {
//        String username = (String) session.getAttribute("username");
//        if (username != null) {
//            return new ModelAndView("report");
//        } else {
//            return new ModelAndView("redirect:/portal/login");
//        }
//    }
//}
