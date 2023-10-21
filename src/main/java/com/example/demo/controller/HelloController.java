package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Date;
import java.util.List;

@RestController
public class HelloController {
    Date date = new Date();
    @GetMapping("/hello")
    public List<Student> sayHello(){
        return List.of(
                new Student("Yahya", "Mourid", new Date("05/19/2002"))
        );
    }
}
