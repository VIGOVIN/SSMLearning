package com.skunk.test;

import com.skunk.dao.AccountDao;
import com.skunk.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    private static SqlSessionFactory ssf;

    static {

        String resource = "sqlMapConfig.xml";
        InputStream in = null;

        try {
            in = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
            ssf = ssfb.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void run1() {
        SqlSession session = ssf.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAll();
        for(Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void run2() {
        SqlSession session = ssf.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = new Account();
//        account.setId(3);
        account.setName("王五");
        account.setMoney(800d);
        accountDao.saveAccount(account);

        //提交事务
        session.commit();

        List<Account> list = accountDao.findAll();
        for(Account a : list) {
            System.out.println(a);
        }
    }


}
