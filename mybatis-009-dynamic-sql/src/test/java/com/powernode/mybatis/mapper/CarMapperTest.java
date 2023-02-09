package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/10 1:58
 * @Version 1.0.1
 */
public class CarMapperTest {

    @Test
    public void selectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList= mapper.selectByMultiCondition("21",2.0,"21");
        carList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList= mapper.selectByMultiConditionWithWhere("1",null,"2");
        carList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList= mapper.selectByMultiConditionWithTrim("1",3.0,"");
        carList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void updateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(2L,null,"sdasd",null,null,null);
        mapper.updateById(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateBySet() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(3L,null,"sdasd",null,null,null);
        mapper.updateBySet(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByChoose() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
         List<Car> carList= mapper.selectByChoose("",null,"3");
         carList.forEach(System.out::println);
         sqlSession.close();
    }

    @Test
    public void deleteByIds() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids={11L,12L,13L};
        int count= mapper.deleteByIds(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertBatch() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList=new ArrayList<>();
        Car car1=new Car(null,"12","sdasd2",null,null,null);
        Car car2=new Car(null,"da","sdasd3",null,null,null);
        Car car3=new Car(null,"das","sdasd4",null,null,null);
        Car car4=new Car(null,"dassd","sdasd5",null,null,null);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        int count= mapper.insertBatch(carList);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteByIds2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids={25L,26L,27L};
        int count= mapper.deleteByIds2(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}