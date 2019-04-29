package com.spring2019.transformer;

import com.spring2019.entity.Account;
import com.spring2019.model.AccountModel;
import org.springframework.stereotype.Service;


public interface AccountTransformer {
    public AccountModel entityToModel(Account entity);

    public Account modelToEntity(AccountModel model);
}
