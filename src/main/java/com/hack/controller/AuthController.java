package com.hack.controller;

import com.hack.dto.SignInRequest;
import com.hack.dto.SignUpRequest;
import com.hack.model.UserForm;
import com.hack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lnurullina
 */
@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/sign_in")
    public String getSignIn(@RequestParam(value = "error", required = false) Boolean error,
                            Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("authForm", new SignInRequest());
        return "sign_in";
    }

    @RequestMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new SignUpRequest());
        return "sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") SignUpRequest userForm,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign_up";
        }
        userService.signUp(userForm);
        return "redirect:/home";
    }
}
