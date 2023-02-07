package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author iyeee
 * @Date 2023/2/8 2:06
 * @Version 1.0.1
 */
public class ConfigurationTest {
    @Test
    public void testEnvironment() throws IOException {
        // 获取sqlSessionFactory对象（采用默认的方法）
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));


        // 指定环境 通过环境ID
        SqlSessionFactory sqlSessionFactory1= sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "mybatisDB");
        SqlSession sqlSession = sqlSessionFactory1.openSession();
        int insert = sqlSession.insert("car.insertCar");
        sqlSession.commit();
        sqlSession.close();
        System.out.println(insert);

    }
}
