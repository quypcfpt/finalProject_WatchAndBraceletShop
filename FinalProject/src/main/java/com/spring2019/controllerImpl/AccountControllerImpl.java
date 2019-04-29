package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.AccountController;
import com.spring2019.entity.Account;
import com.spring2019.entity.Product;
import com.spring2019.model.*;
import com.spring2019.repository.AccountRepository;
import com.spring2019.service.AccountService;
import com.spring2019.transformer.AccountTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
public class AccountControllerImpl extends AbstractController implements AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerImpl.class);
    @Autowired
    AccountRepository repository;
    @Autowired
    AccountService service;
    @Autowired
    AccountTransformer transformer;

    @Override
    public String loadAllAccountActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiAccountModel> response = new Response<MultiAccountModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(sortBy).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(sortBy).descending();
        }

        Pageable pageable = null;
        if (page > 0) {
            pageable = PageRequest.of(page - 1, size, sortable);
        }

        LOGGER.info("Start load all accounts active");

        try {
            MultiAccountModel data = new MultiAccountModel();

            List<AccountModel> resultList = new ArrayList<>();
            if (page > 0) {
                Page<Account> accounts = service.getAllAccountsActive(pageable);

                for (Account item : accounts) {
                    resultList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(accounts.getTotalPages());
                data.setTotalRecord(accounts.getTotalElements());
            }
            data.setListAccount(resultList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all accounts active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadAllAccount(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiAccountModel> response = new Response<MultiAccountModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(sortBy).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(sortBy).descending();
        }

        Pageable pageable = null;
        if (page > 0) {
            pageable = PageRequest.of(page - 1, size, sortable);
        }

        LOGGER.info("Start load all accounts  deactive");

        try {
            MultiAccountModel data = new MultiAccountModel();

            List<AccountModel> resultList = new ArrayList<>();
            if (page > 0) {
                Page<Account> accounts = service.getAllAccounts(pageable);

                for (Account item : accounts) {
                    resultList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(accounts.getTotalPages());
                data.setTotalRecord(accounts.getTotalElements());
            }
            data.setListAccount(resultList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all accounts deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String checkLogin(String username, String password) {
        Response<AccountModel> response = new Response<AccountModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start check account");
        try {
            Account account = service.getAccountByUsername(username,password);
            AccountModel data = transformer.entityToModel(account);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End check account");
        }catch (Exception e){
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }

        return gson.toJson(response);
    }
}
