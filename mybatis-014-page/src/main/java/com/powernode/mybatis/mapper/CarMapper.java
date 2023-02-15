package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Car> selectByPage(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
    List<Car> selectAll();
}
