package com.opentelemetry.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/service")
public class TraceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/path1")
    public String getPath1()
    {
        ResponseEntity<String> responseEntity= restTemplate
                .getForEntity("http://localhost:8090/service/path2", String.class);
        return responseEntity.getBody().toString();
    }

    @GetMapping("/path2")
    public String getPath2()
    {
        return "hello this data is from path2 localhost:8090";
    }

}
