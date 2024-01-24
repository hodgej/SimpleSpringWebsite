package com.jackhodge.DataViewTool.controller;

//import com.jackhodge.DataViewTool.model.UserPrincipal;
//import com.jackhodge.DataViewTool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/loginform")
    public String loginForm(){
        // Insert logic to check if user is already logged in
        return "loginform";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password
                        )
    {
        return "loginsuccess";
    }
}
