package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author iyeee
 * @Date 2023/2/9 20:43
 * @Version 1.0.1
 */
public class StudentMapperTest {

    @Test
    public void selectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(2L);
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectByName() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("ls");
        students.forEach(System.out::println);
        sqlSession.close();
    }

    // java.util.Date java.sql.Date 都是简单类型
    @Test
    public void selectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        List<Student> students = mapper.selectByBirth(simpleDateFormat.parse("2022-10-11"));
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectBySex() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectBySex('男');
        students.forEach(System.out::println);
        sqlSession.close();

    }

    @Test
    public void insertStudentMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("name","zs");
        map.put("age","22");
        map.put("height","1.82");
        map.put("sex","男");
        map.put("birth",new Date());
        mapper.insertStudentMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertByPOJO() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.insertByPOJO(new Student(null,"zs",50,10.0,new Date(),'女'));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByNameAndSex() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("zs", '男');
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectByNameAndSex2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mapper实际上 指向了代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // selectByNameAndSex2是代理方法
        List<Student> students = mapper.selectByNameAndSex2("zs", '男');
        students.forEach(System.out::println);
        sqlSession.close();
    }
}