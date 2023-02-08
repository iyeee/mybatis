package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * @Author iyeee
 * @Date 2023/2/8 18:20
 * @Version 1.0.1
 */
// Dao中的方法就是做CRUD 所以方法大部分都是 insertXXX update delete
public interface AccouontDao {
    Account selectByActno(String actno);
    int updateByActno(Account account);
}
