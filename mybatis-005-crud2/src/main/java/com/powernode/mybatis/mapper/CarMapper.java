package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/9 3:33
 * @Version 1.0.1
 */
public interface CarMapper {

    List<Car> selectByCarLike(String brand);
    int insert(Car car);
    int deleteById(Long id);
    int update(Car car);
    Car selectById(Long id);
    List<Car> selectAll();

}
