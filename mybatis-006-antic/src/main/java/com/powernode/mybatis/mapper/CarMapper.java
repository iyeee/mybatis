package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/9 4:08
 * @Version 1.0.1
 */
public interface CarMapper {
    int insertCarUserGeneratedKeys(Car car);
    List<Car> selectByType(String carType);
    List<Car> selectAllByAscOrDesc(String ascOrDesc);

    int deleteBatch(String ids);

    List<Car> selectByCarLike(String brand);

}
