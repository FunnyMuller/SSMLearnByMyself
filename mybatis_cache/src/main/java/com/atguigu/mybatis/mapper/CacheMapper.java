package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /**
     * 查询用户信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);
}
