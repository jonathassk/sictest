package com.example.demo.infrastructure.interfaces;

import com.example.demo.domain.Poll;

import java.util.List;

public interface PollService {
    Poll createPoll(int timeToEnd, String name);
    List<Poll> getAllPoll();
    Poll getPoll(Long pollId);
}
