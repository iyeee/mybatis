package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.CarExample;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class CarMapperTest {

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars= mapper.selectByExample(null);
        System.out.println(cars);
        //  QBC 风格：Query By Criteria 一种查询方式，比较面向对象，看不到sql语句
        // 根据条件查询
        CarExample carExample=new CarExample();
        carExample.createCriteria().andBrandLike("大众速腾%")
                        .andGuidePriceGreaterThan(new BigDecimal(20.0));
        // 添加or
        carExample.or().andCarTypeEqualTo("燃油车");
        List<Car> cars2= mapper.selectByExample(carExample);
        System.out.println(cars2);
        sqlSession.close();
    }

    @Test
    public void selectByPrimaryKey() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car= mapper.selectByPrimaryKey(168L);
        System.out.println(car);
        sqlSession.close();

    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}