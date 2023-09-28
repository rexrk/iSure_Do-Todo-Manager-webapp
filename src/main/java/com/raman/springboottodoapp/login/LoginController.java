package com.raman.springboottodoapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name"})
public class LoginController {

    private final LoginAuthenticationService authenticationService;

    public LoginController(LoginAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login-page", method = RequestMethod.GET)
    public String loginPage() {
        return "login";

    }

    @RequestMapping(value = "login-page", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if(authenticationService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }
        model.put("errMessage", "Name or Password is invalid !!");
        return "login";
    }

}