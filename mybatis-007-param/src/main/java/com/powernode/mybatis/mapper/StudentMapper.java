package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author iyeee
 * @Date 2023/2/9 20:36
 * @Version 1.0.1
 */
public interface StudentMapper {
    // 当接口中的参数只有一个，并且参数类型都是简单类型
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);

    int insertStudentMap(Map<String,Object> map);

    int insertByPOJO(Student student);


    // map存储参数
    // map.put("arg0",name)
    // map.put("arg1",sex)
    // map.put("param1",sex)
    // map.put("param2",sex)
    List<Student> selectByNameAndSex(String name,Character sex);

    List<Student> selectByNameAndSex2(@Param("name") String name,@Param("sex") Character sex);
}
