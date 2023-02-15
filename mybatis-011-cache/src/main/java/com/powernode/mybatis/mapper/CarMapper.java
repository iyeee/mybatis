package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    Car selectById(Long id);
    Car selectById2(Long id);

    int insertClazz(@Param("cid")Integer cid,@Param("cname")String cname);
}
