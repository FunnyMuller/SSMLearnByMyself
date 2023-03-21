package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }
    @RequestMapping("/test/view/forward")
    public String InternalResourcesView(){
        return "forward:/test/model";
    }
    @RequestMapping("/test/view/redirect")
    public String RedirectView(){
        return "redirect:/test/model";
    }
}
