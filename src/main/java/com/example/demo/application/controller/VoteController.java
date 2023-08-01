package com.example.demo.application.controller;

import com.example.demo.domain.Polls;
import com.example.demo.domain.VoteRequest;
import com.example.demo.infrastructure.interfaces.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;
    private final Logger logger = Logger.getLogger(VoteController.class.getName());

    @PostMapping("/post")
    public ResponseEntity<Polls> createVote(@RequestBody VoteRequest voteRequest) {
        logger.info("[Voting] starting voting process, user with cpf begins with: " + voteRequest.getUserCpf().substring(0,3));
        Polls result = voteService.addVote(voteRequest.getVote(), voteRequest.getUserCpf(), voteRequest.getPollId());
        return ResponseEntity.ok(result);
    }
}
