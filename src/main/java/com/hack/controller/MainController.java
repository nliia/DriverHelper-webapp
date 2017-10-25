package com.hack.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lnurullina
 */
@Controller
public class MainController {

    @RequestMapping("/home")
    public String getHello(Model model) {
        model.addAttribute("var", SecurityContextHolder.getContext().getAuthentication().getCredentials());
        return "hello";
    }
}
