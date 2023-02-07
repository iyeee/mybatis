package com.powernode.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author iyeee
 * @Date 2023/2/8 0:18
 * @Version 1.0.1
 */
public class CarMapperTest {


    @Test
    public void testInsertCarByUtil(){
        SqlSession  sqlSession=SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar");
        sqlSession.commit();
        System.out.println(count);
    }

}
