package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Log;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author iyeee
 * @Date 2023/2/9 4:39
 * @Version 1.0.1
 */
public class LogMapperTest {

    @Test
    public void selectAllByTable() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs = mapper.selectAllByTable("20220901");
        logs.forEach(System.out::println);
    }
}