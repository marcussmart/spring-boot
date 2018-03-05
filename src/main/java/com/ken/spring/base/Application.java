package com.ken.spring.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by s on 2018/3/1.
 */

@SpringBootApplication(scanBasePackages = {"com.ken.spring.boot", "com.ken.spring.base.config"})
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
