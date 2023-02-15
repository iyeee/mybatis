package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapperTest {

    @Test
    public void insert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"666","da",1.0,"2020-11-11","da");
        mapper.insert(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteById(169L);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(169L,"6326","da",1.0,"2020-11-11","da");
        mapper.update(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(172L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
    }
}