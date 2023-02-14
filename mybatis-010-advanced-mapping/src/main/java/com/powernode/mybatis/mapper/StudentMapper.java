package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> selectByCidStep2(Integer cid);
    // 根据id获取学生信息，同时获取学生关联的班级信息
    Student selectById(Integer id);

    // 一条sql语句 association
    Student selectByIdAssociation(Integer id);

    // 分布查询有点 1.可复用性强
    //            2.延迟加载/懒加载 （用到再查询），提高性能
    //  association中fetchType=lazy 默认不开启
    // 分布查询1 先根据学生的sid查询学生的信息
    Student selectByIdStep1(Integer sid);





}
