package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView list() {
        List<User> list = userService.list();
        ModelAndView mv = new ModelAndView();
        // 设置模型数据
        mv.addObject("list", list);
        // 设置视图名称
        mv.setViewName("index");//WEB-INF/pages/index.jsp
        return mv;
    }

    @GetMapping("/list2")
    public String list2(Model model) {
        List<User> list = userService.list();
        model.addAttribute("list",list);
        return "index"; // WEB-INF/pages/index.jsp
    }

    @GetMapping("/list3")
    @ResponseBody // 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public List<User> list3() {
        List<User> list = userService.list();
        return list;
    }
}
