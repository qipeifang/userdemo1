package com.example.userdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //指定这是一个 spring boot的应用程序.
public class Userdemo1Application {
    // SpringApplication 用于从main方法启动Spring应用的类。
    public static void main(String[] args) {
        SpringApplication.run(Userdemo1Application.class, args);
    }

}
