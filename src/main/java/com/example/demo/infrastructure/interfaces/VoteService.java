package com.example.demo.infrastructure.interfaces;

import com.example.demo.domain.Polls;

public interface VoteService {

    Polls addVote(String vote, String cpf, Long pollId);
}
