package com.powernode.bank.service;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;

/**
 * @Author iyeee
 * @Date 2023/2/8 18:12
 * @Version 1.0.1
 */
public interface AccountService {
    void transfer(String fromActno,String toaActno,double money) throws MoneyNotEnoughException, TransferException;
}
