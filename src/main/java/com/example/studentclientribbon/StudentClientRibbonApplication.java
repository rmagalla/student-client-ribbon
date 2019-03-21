package com.example.studentclientribbon;

import com.example.studentclientribbon.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "eureka", configuration = RibbonConfiguration.class)
public class StudentClientRibbonApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudentClientRibbonApplication.class, args);
  }

}
