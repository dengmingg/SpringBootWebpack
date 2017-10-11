package com.ruandao.springbootwebpack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ruandao.springbootwebpack")
public class SpringBootWebpackApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebpackApplication.class, args);
    }

}
