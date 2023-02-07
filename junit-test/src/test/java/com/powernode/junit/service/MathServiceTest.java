package com.powernode.junit.service;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author iyeee
 * @Date 2023/2/7 20:54
 * @Version 1.0.1
 */
public class MathServiceTest {

    @Test
    public void sum() {
        int sum = new MathService().sum(1, 2);
        System.out.println(sum);
        int expected=4;
        // 加入断言比较实际值和期望值
        Assert.assertEquals(sum,expected);
    }
}