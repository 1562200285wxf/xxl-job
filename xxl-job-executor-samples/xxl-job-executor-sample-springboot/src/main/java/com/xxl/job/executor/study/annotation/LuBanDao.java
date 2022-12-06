package com.xxl.job.executor.study.annotation;

import org.apache.ibatis.annotations.Select;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 11:18
 * @description：mapper
 */
public interface LuBanDao {

    @Select("select * from student")
    public String query();
}
