package com.powernode.bank.exceptions;

/**
 * @Author iyeee
 * @Date 2023/2/8 20:48
 * @Version 1.0.1
 */
public class TransferException extends Exception{
    public TransferException() {
    }

    public TransferException(String message) {
        super(message);
    }
}
