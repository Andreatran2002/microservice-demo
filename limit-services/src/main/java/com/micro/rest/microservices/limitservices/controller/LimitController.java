package com.micro.rest.microservices.limitservices.controller;


import com.micro.rest.microservices.limitservices.bean.Limits;
import com.micro.rest.microservices.limitservices.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimum(),
                configuration.getMaximum());
//		return new Limits(1,1000);
    }


}
