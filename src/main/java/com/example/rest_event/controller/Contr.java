package com.example.rest_event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hoho")
public class Contr {

    @GetMapping
    @ResponseBody
    public String haha(@RequestParam(defaultValue = "jakeis imie") String name){
        return "asdfasdf" + " " + name;
    }
}
