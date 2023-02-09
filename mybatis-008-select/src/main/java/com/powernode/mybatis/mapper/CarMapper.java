package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @Author iyeee
 * @Date 2023/2/10 0:37
 * @Version 1.0.1
 */
public interface CarMapper {
    Long selectTotal();
    Car selectById(Long id);
    List<Car> selectAll();
    List<Car> selectAllByMapUnderscoreToCamelCase();
    List<Car> selectAllByResultMap();

    Map<String,Object> selectByIdRetMap(Long id);
    List<Map<String,Object>> selectByIdListMap();

    // 卡的id作为key 大map
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();


}
