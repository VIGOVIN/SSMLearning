package com.skunk.service;

import com.skunk.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 账户Service
 */
public interface AccountService {

    //查询所有账户信息
    List<Account> findAll();

    //保存账户信息
    void saveAccount(Account account);
}
