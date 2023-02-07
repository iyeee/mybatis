package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author iyeee
 * @Date 2023/2/7 21:23
 * @Version 1.0.1
 */
public class SqlSessionUtil {
    // 工具类一般构造方法私有化，所有方法都是静态的，不需要new对象
    private SqlSessionUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    // 类加载时执行
    // SqlSessionUtil工具类第一次加载的时候，解析mybatis-config.xml 创建SqlSessionFactory对象
    static {
        try {
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    // public static SqlSessionFactory openSession() {
    //     SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //     SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
    //     SqlSession sqlSession = sqlSessionFactory.openSession();
    //
    //     return sqlSession;
    // }
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
