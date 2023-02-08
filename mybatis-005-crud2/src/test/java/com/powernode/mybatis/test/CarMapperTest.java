package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/9 3:45
 * @Version 1.0.1
 */
public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int insert = mapper.insert(new Car(null, "888", "212", 3.0, "212", "21"));
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteById(9L);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int insert = mapper.update(new Car(12L, "888", "212", 3.0, "212", "21"));
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(3L);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();


    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(System.out::println);
        sqlSession.commit();
        sqlSession.close();

    }
}
