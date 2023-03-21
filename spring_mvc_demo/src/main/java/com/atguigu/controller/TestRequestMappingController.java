package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1.@RequestMapping注解标识的位置
 * @RequestMapping标识一个类:设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法:设置映射请求请求路径的具体信息
 * 2.@RequestMapping注解value属性
 * 作用:通过请求的请求路径匹配请求
 * value属性时数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 即当前请求会被注解所标识的方法进行处理
 * 3.@RequestMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性时RequestMethod类型的数组，即当前流量器所发送请求的请求方式匹配
 * 则当前请求就会被注解所标识的方法进行处理
 * 4.@RequestMapping注解的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * param四种表达式：
 * “param”：表示当前所匹配请求的请求参数中必须携带param参数
 * “！param”：表示当前所匹配请求的请求参数中一定不携带param参数
 * “param=value”：表示当前请求的请求参数一定要等于value
 * “param！=value”：表示当前请求的请求参数一定要不等于value
 */
@Controller
public class TestRequestMappingController {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "success";
    }
    @RequestMapping("/**/test/ant")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username){
        System.out.println(username);
        System.out.println("id:"+id);
        return "success";
    }
}
