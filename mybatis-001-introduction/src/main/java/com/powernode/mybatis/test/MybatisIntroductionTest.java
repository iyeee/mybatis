package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author iyeee
 * @Date 2023/2/7 3:59
 * @Version 1.0.1
 */
public class MybatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        // 默认从类的根路径查找资源
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        // 输入流指向配置文件
        // 一般情况下，一个数据库对应一个SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = build.openSession();

        int count = sqlSession.insert("insertCar");

        System.out.println(count);

        sqlSession.commit();

    }
}
