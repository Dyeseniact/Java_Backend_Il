package com.example.s72.controller;

import com.example.s72.entity.Auto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro")
public class DemoController {
    @PostMapping("/auto")
    public void recibe(@RequestBody Auto auto){
        System.out.println(auto.toString());
    }
}
