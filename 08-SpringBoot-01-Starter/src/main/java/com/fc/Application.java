package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

//启动类

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //Arrays.toString把数组内容遍历
        System.out.println("给jvm传递参数："+ Arrays.toString(args));
        SpringApplication.run(Application.class, args);
    }

}
