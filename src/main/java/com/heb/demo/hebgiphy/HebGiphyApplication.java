package com.heb.demo.hebgiphy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HebGiphyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HebGiphyApplication.class, args);
    }

}
