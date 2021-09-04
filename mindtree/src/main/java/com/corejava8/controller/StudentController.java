package com.corejava8.controller;

import com.corejava8.lambda.StudentLambda;
import com.corejava8.lambda.StudentWelcome;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/add")
    public String getLambdaTest(){
       int value = invokeLambdaClass(8,8);
       studentGreeting();
        return  studentGreeting() + value;
    }

    public String studentGreeting(){
        StudentWelcome studentWelcome = () -> "StudentWelcome Congrats first year !!!!";
        return studentWelcome.greeting();
    }

//Simple StudentLambda class and invoking example
    private int invokeLambdaClass(int x,int y) {
        StudentLambda studentLambda = (a, b) -> a + b;
        return studentLambda.findStudentAge(x,y);
    }
}
