package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

public interface ClazzMapper {
    Clazz selectByIdStep1(Integer cid);

    Clazz selectByCollection(Integer cid);


}
