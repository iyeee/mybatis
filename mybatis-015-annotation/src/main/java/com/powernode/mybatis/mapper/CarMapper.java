package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarMapper {
    @Insert("insert into t_car values (null,#{carNo},#{brand},#{guidePrice},#{produceTime},#{carType})")
    int insert(Car car);
    @Delete("delete from t_car where id=#{id}")
    int deleteById(Long id);
    @Update("update t_car set car_num=#{carNo},brand=#{brand},guide_price=#{guidePrice},produce_time=#{produceTime},car_type=#{carType}")
    int update(Car car);
    @Select("select * from t_car where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "carNo",column = "car_num"),
            @Result(property = "brand",column = "brand"),
            @Result(property = "guidePrice",column = "guide_price"),
            @Result(property = "produceTime",column = "produce_time"),
            @Result(property = "carType",column = "car_type"),
    })
    Car selectById(Long id);
}
