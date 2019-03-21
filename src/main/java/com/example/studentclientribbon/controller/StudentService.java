package com.example.studentclientribbon.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/v1/")
public class StudentService {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping(value = "/client/{id}")
  public String getStudentService(@PathVariable String id) {

    String response = restTemplate
        .exchange("http://student-service/student/{id}", HttpMethod.GET, null,
            new ParameterizedTypeReference<String>() {
            }, id).getBody();

    return "OK - " + response + " - " + new Date();
  }

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
