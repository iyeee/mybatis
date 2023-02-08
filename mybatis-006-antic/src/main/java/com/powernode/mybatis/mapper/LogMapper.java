package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Log;

import java.util.List;

/**
 * @Author iyeee
 * @Date 2023/2/9 4:37
 * @Version 1.0.1
 */
public interface LogMapper {
    List<Log> selectAllByTable(String date);
}
