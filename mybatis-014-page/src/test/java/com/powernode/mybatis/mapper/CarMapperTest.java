package com.powernode.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarMapperTest {

    @Test
    public void selectByPage() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        int pageSize=3;
        int pageNum=5;
        int startIndex=(pageNum-1)*pageSize;

        List<Car> cars=mapper.selectByPage(startIndex,pageSize);
        System.out.println(cars);
        sqlSession.close();
    }

    @Test
    public void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        PageHelper.startPage(2,3);
        List<Car> cars = mapper.selectAll();
        // 封装分页信息
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        System.out.println(carPageInfo);
        sqlSession.close();
    }
}