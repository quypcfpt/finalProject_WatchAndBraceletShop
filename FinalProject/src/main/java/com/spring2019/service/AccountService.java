package com.spring2019.service;

import com.spring2019.entity.Account;
import org.springframework.stereotype.Service;


@Service
public interface AccountService {
    Account getAccountByUsername(String username, String password);

    boolean createNewAccount(Account entity);

    Account getAccountByUsernameAndIsAdmin(String username, String password);

    void updateAccount(Account account);
}
