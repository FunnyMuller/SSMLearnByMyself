package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 判断用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 添加用户信息功能
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录(使用@param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
