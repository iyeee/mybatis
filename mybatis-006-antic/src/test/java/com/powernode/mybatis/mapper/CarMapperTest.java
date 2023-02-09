package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author iyeee
 * @Date 2023/2/9 4:16
 * @Version 1.0.1
 */
public class CarMapperTest {

    @Test
    public void selectByType() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.selectByType("21").forEach(System.out::println);
    }

    @Test
    public void selectAllByAscOrDesc() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
       mapper.selectAllByAscOrDesc("asc").forEach(System.out::println);

    }

    @Test
    public void deleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count= mapper.deleteBatch("5,6,7");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void selectByCarLike() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarLike("2");
        cars.forEach(System.out::println);

    }

    @Test
    public void insertCarUserGeneratedKeys() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"9991","dasd",30.0,"123","燃油车");
        mapper.insertCarUserGeneratedKeys(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarUserGeneratedKeys() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"9991","dasd",30.0,"123","燃油车");
        mapper.insertCarUserGeneratedKeys(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();

    }
}