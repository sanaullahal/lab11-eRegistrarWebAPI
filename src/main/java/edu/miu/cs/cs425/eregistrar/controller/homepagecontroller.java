package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homepagecontroller {
    @GetMapping(value = {"/","/eregistrar","/eregistrar/home"})
    public String displayhomepage(){
        return "home/index";
    }



}
