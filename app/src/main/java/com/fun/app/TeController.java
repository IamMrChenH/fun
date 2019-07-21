package com.fun.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IamMr
 * @date 2019年07月21日 —— 19:59
 */
@RestController
public class TeController {

    @GetMapping("login")
    public String login() {
        return "/login.html";
    }


}
