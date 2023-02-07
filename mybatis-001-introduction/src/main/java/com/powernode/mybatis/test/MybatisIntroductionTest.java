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
        // InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        // 默认从类的根路径查找资源
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        // 输入流指向配置文件
        // 一般情况下，一个数据库对应一个SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(inputStream);

        // 事务管理器是jdbc的情况下 底层实际上会执行 conn.setAutoCommit(false)，才表示有事务
        SqlSession sqlSession = build.openSession();

        // 表示没有开启事务，autoCommit是true，自动提交的
        // SqlSession sqlSession = build.openSession(true);

        int count = sqlSession.insert("insertCar");

        System.out.println(count);


        // 手动提交
        sqlSession.commit();

    }
}
