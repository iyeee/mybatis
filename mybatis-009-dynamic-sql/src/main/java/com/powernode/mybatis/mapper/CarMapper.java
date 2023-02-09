package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/10 0:37
 * @Version 1.0.1
 */
public interface CarMapper {
    List<Car> selectByMultiCondition(@Param("brand")String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);
    List<Car> selectByMultiConditionWithWhere(@Param("brand")String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);
    List<Car> selectByMultiConditionWithTrim(@Param("brand")String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    int updateById(Car car);
    int updateBySet(Car car);
    List<Car> selectByChoose(@Param("brand")String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);
    int deleteByIds(@Param("ids")Long[] ids);
    int insertBatch(@Param("cars")List<Car> cars);

    int deleteByIds2(@Param("ids")Long[] ids);


}
