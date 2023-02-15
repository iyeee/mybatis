package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CarMapperTest {

    @Test
    public void selectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(167L);
        System.out.println(car);


        // 使用的是同一个session，ThreadLocal
        // 一级缓存 范围是sqlSession
        // 一级缓存清空 1.执行了sqlSession.clearCache() 2.执行了insert delete update 不管操作哪张表
        // sqlSession.clearCache();

        CarMapper mapper2=sqlSession.getMapper(CarMapper.class);
        mapper2.insertClazz(2000,"高三三班");
        Car car2 = mapper2.selectById(167L);
        System.out.println(car2);
        sqlSession.commit();
        sqlSession.close();
        //
        // SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        // SqlSession sqlSession1 = build.openSession();
        // SqlSession sqlSession2 = build.openSession();
        // CarMapper mapper3 = sqlSession1.getMapper(CarMapper.class);
        // CarMapper mapper4 = sqlSession2.getMapper(CarMapper.class);
        // Car car3 = mapper3.selectById(167L);
        // System.out.println(car3);
        // Car car4 = mapper4.selectById(167L);
        //
        // System.out.println(car4);


    }

    @Test
    public void selectById2() throws IOException {
        // 二级缓存对应SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = build.openSession();
        SqlSession sqlSession2 = build.openSession();
        CarMapper mapper3 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper4 = sqlSession2.getMapper(CarMapper.class);
        Car car3 = mapper3.selectById(167L);
        System.out.println(car3);

        // 写入二级缓存 两次查询之间执行了增删改，缓存取消
        sqlSession1.close();
        Car car4 = mapper4.selectById(167L);
        System.out.println(car4);
        sqlSession2.close();
    }
}