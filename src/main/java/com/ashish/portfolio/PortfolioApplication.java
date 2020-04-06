package com.ashish.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RestController("/api")
public class PortfolioApplication {

  public static void main(String[] args) {
    SpringApplication.run(PortfolioApplication.class, args);
  }
}
