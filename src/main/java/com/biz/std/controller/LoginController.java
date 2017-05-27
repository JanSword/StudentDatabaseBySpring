package com.biz.std.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by dell on 2017/5/17.
 */
@Controller
@RequestMapping("/stddb")
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(HttpSession httpSession, String Username, String Password) {
        httpSession.setAttribute("Username", Username);
        httpSession.setAttribute("Password", Password);
        if (Objects.equals(Username, "root") && Objects.equals(Password, "123456")) {
            return "redirect:student/studentMain";
        }
        return "redirect:login";
    }

}
