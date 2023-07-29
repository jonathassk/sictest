package com.example.demo.application.controller;

import com.example.demo.infrastructure.interfaces.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PollController {
    @Autowired
    private PollService pollService;

    private Logger logger;

    @GetMapping("/")
    public String getAllPolls(){
        return "Hello World from Spring Boot";
    }

    @PostMapping("/")
    public ResponseEntity<String> createPoll(int timeToEnd, String name) {
        logger.info("[CREATE POLL] creating pool name: " + name);
        pollService.createPoll(timeToEnd, name);
        return ResponseEntity.status(201).body("poll number created!");
    }
}
