package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmptyCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition1 = dynamicSQLMapper.getEmpByChoose(new Emp(null, "张三", 20, "男"));
        empByCondition1.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"小明1",20,"男");
        Emp emp2 = new Emp(null,"小明2",20,"男");
        Emp emp3 = new Emp(null,"小明3",20,"男");
        List<Emp> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        dynamicSQLMapper.insertMoreEmp(list);
        sqlSession.close();
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{5,6,7};
        dynamicSQLMapper.deleteMoreEmp(empIds);;
        sqlSession.close();
    }
}
