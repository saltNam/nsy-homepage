package com.nsy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NsyHomepageApplication {

    public static void main(String[] args) {
        SpringApplication.run(NsyHomepageApplication.class, args);
        System.out.println("잘 굴러가나요");
    }

}
