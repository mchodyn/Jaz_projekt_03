package com.example.jaz3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Jaz3Application {

    public static void main(String[] args) {
        SpringApplication.run(Jaz3Application.class, args);
    }
}
//http://localhost:8080/swagger-ui.html
//http://localhost:8080/h2/