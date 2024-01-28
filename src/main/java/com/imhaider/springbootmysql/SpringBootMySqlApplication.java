package com.imhaider.springbootmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringBootMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMySqlApplication.class, args);
    }

}
