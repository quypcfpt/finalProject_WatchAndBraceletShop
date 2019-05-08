package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.UserController;
import com.spring2019.entity.User;
import com.spring2019.model.DatatableModel;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
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

    @Override
    public String loadAllUserAdmin() {
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load all User");

        try {
            List<UserModel> userModels = new ArrayList<>();
            List<User> users = service.getAll();

            for (User user : users) {
                userModels.add(transformer.entityToModel(user));
            }
            DatatableModel result = new DatatableModel();
            result.setData(userModels);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, userModels);
            LOGGER.info("End load all User");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String updateUserById(int id) {
        String msg = "User can not update status.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start update status  User Id");
        try {

            service.updateStatus(id);
            msg = "User status is updated.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End update User status by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loginUser(String accountModel, HttpSession session) {
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        try {
            LOGGER.info("Check admin login: " + accountModel);

            UserModel userModel = gson.fromJson(accountModel, UserModel.class);
            User accountEntity = transformer.modelToEntity(userModel);
            User account = service.getAccountByUsernameAndIsAdmin(accountEntity.getUsername(), accountEntity.getPassword());
            User user = service.getAccountByUsernameAndIsAdmin(accountEntity.getUsername(), accountEntity.getPassword());
            if (account != null && user ==null) {
                LOGGER.info("Admin account is authenticated");
                session.setAttribute("username", account.getUsername());
                response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, "1");
            }else if (user != null && account !=null){
                LOGGER.info("User account is authenticated");
                session.setAttribute("username", user.getUsername());
                response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, "2");
            }
                else {
                LOGGER.info("Admin account not found");
                response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, "failed");
            }
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }
}
