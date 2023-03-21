package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * 1.通过ModelAndView
         * Model:向请求域钟共享数据
         * View:设置逻辑视图实现跳转页面
         * 2.Model
         *
         * 3.ModelMap
         *
         * 4.map
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testSessionScope","hello,ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","hello");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello");
        return "success";
    }
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello");
        return "success";
    }
}
