package com.atguigu.myBatis.mapper;

import com.atguigu.myBatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询查询员工以及所对应的部门信息的第二步
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByStepTow(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及部门中的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询查询部门以及部门信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
