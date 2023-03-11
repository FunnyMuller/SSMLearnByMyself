package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testGeCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<User> list = mapper.getAllUser();
//        list.forEach(System.out::println);
        Integer count = mapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = mapper.getUserByIdToMap(1);
        //{password=123, gender=男, id=1, age=23, email=12345@qq.com, username=root}
        System.out.println(map);
    }
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String,Object>> list = mapper.getAllUserToMap();
        //{password=123, gender=男, id=1, age=23, email=12345@qq.com, username=root}
        System.out.println(list);
        sqlSession.close();
//        Map<String, Object> map = mapper.getAllUserToMap();
//        System.out.println(map);
    }
}
