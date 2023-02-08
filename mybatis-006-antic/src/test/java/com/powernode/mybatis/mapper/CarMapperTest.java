package com.powernode.mybatis.mapper;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}