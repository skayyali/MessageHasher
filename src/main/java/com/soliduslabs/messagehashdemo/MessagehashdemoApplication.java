package com.soliduslabs.messagehashdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.soliduslabs")
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class MessagehashdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessagehashdemoApplication.class, args);
    }
}
