package com.example.demo.infrastructure.interfaces;

import com.example.demo.domain.Polls;

import java.util.List;
import java.util.Optional;

public interface PollService {
    Polls createPoll(int timeToEnd, String name);

    List<Polls> getAllPolls();

    Optional<Polls> getPoll(Long pollId);
}
