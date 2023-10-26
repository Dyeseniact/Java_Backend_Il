package com.example.s72.controller;

import com.example.s72.entity.Auto;
import com.example.s72.entity.Casa;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/casa")
    public ResponseEntity<Casa> recibeCasa(@RequestBody Casa casa){
        System.out.println(casa.toString());
        return ResponseEntity.status(200).body(casa);
    }
}
