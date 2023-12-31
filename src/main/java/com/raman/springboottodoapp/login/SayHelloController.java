package com.raman.springboottodoapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    //Hard Coded text response
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "<h1>" +
                "Hello ! What are you up to ?" +
                "</h1>";
    }

    //Jsp generated Response
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }

}