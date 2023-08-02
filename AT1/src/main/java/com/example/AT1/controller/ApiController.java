package com.example.AT1.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/getFilteredData")
    public String getFilteredData(
            @RequestParam(defaultValue = "2") String pageNo,
            @RequestParam String ids
    ) {
        return producerTemplate.requestBody("direct:start", null, String.class);
    }
}

