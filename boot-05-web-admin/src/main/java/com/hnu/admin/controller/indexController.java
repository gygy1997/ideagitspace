package com.hnu.admin.controller;


import com.hnu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class indexController {


    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }



    @PostMapping("/login")
    public String main(User user, HttpSession session,Model model){
        if (!(StringUtils.isEmpty(user.getUsername())) && "123456".equals(user.getPassword()))
        {
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";  //重定向，然后下面GET住，直接去main，防止重复提交

        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public  String mainPage(HttpSession session,Model model) {
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
//    }
        log.info("当前方式是:{}","mainPage");
        return "main";
    }
}
