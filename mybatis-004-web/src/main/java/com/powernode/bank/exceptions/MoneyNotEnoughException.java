package com.powernode.bank.exceptions;

/**
 * @Author iyeee
 * @Date 2023/2/8 20:40
 * @Version 1.0.1
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
