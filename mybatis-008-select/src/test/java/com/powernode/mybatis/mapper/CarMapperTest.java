package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author iyeee
 * @Date 2023/2/10 0:48
 * @Version 1.0.1
 */
public class CarMapperTest {

    @Test
    public void selectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(3L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String,Object> map= mapper.selectByIdRetMap(3L);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void selectByIdListMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.selectByIdListMap().forEach(System.out::print);
        sqlSession.close();
    }

    @Test
    public void selectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> map= mapper.selectAllRetMap();
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.selectAllByResultMap().forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectAllByMapUnderscoreToCamelCase() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.selectAllByMapUnderscoreToCamelCase().forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectTotal() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long total= mapper.selectTotal();
        System.out.println(total);
        sqlSession.close();
    }
}