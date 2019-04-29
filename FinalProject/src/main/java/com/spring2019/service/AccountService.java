package com.spring2019.service;

import com.spring2019.entity.Account;
import com.spring2019.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface AccountService {
    Account getAccountByUsername(String username, String password);

    boolean createNewAccount(Account entity);

    Account getAccountByUsernameAndIsAdmin(String username, String password);

    void updateAccount(Account account);

    public Page<Account> getAllAccountsActive(Pageable pageable);

    public Page<Account> getAllAccounts(Pageable pageable);
}
