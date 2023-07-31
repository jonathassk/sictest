package com.example.demo.application.controller;

import com.example.demo.domain.PollRequest;
import com.example.demo.domain.Polls;
import com.example.demo.infrastructure.interfaces.PollService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("api/polls")
public class PollController {
    @Autowired
    private PollService pollService;

    private final Logger logger = Logger.getLogger(PollController.class.getName());

    @GetMapping("/get")
    public String getAllPolls(){
        return "Hello World from Spring Boot";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Polls>> getPollById(@PathVariable("id") long id) {
        logger.info("[GET POLL BY ID] finding poll id: " + id);
        return ResponseEntity.status(200).body(pollService.getPoll(id));
    }

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<String> createPoll(@RequestBody PollRequest request) {
        logger.info("[CREATE POLL] creating pool name: " + request.getName());
        pollService.createPoll(request.getTimeToEnd(), request.getName());
        return ResponseEntity.status(201).body("poll number created!");
    }
}
