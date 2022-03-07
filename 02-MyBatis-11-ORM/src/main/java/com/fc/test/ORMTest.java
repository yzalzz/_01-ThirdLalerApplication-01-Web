package com.fc.test;

import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.util.MyBatisUtil;
import lombok.Data;
import org.junit.Test;

import java.util.List;
//111
public class ORMTest {
    @Test
    public void testFindOnMap(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> map = accountDao.findOnMap();

        MyBatisUtil.commit();

        for (Account account : map) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindAll(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> all = accountDao.findAll();

        MyBatisUtil.commit();

        for (Account account : all) {
            System.out.println(account);
        }
    }
}
