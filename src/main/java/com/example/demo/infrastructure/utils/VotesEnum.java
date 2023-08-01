package com.example.demo.infrastructure.utils;

public enum VotesEnum {
    SIM("Sim"),
    NAO("Nao");

    private final String vote;


    VotesEnum(String vote) {
        this.vote = vote;
    }

    public String getVote() {
        return vote;
    }
}
