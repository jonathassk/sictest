package com.example.demo.application.service;

import com.example.demo.application.repository.PollRepository;
import com.example.demo.application.repository.VoteRepository;
import com.example.demo.domain.Polls;
import com.example.demo.domain.Votes;
import com.example.demo.infrastructure.utils.VotesEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class VoteServiceImpTest {

    @Mock
    private PollRepository pollRepository;
    @Mock
    private VoteRepository voteRepository;
    @InjectMocks
    private VoteServiceImp voteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addVoteSIMVerifyValue() {
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(returnPoll1()));
        Polls result = voteService.addVote(VotesEnum.SIM.getVote(), "21172933014", 1L);

        Assertions.assertEquals(2, result.getYesQuantity());
        Assertions.assertEquals(0, result.getNoQuantity());
        Assertions.assertEquals(returnPoll1().getName(), result.getName());
    }

    @Test
    void addVoteNaoVerifyValue() {
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(returnPoll1()));
        Polls result = voteService.addVote(VotesEnum.NAO.getVote(), "21172933014", 2L);

        Assertions.assertEquals(1, result.getYesQuantity());
        Assertions.assertEquals(1, result.getNoQuantity());
        Assertions.assertEquals(returnPoll1().getName(), result.getName());
    }

    @Test
    void testAddVoteVerifyMethodExecution() {
        when(pollRepository.findById(anyLong())).thenReturn(Optional.of(returnPoll1()));
        voteService.addVote(VotesEnum.SIM.getVote(), "21172933014", 1L);


        verify(pollRepository, times(1)).findById(anyLong());
        verify(voteRepository, times(1)).save(any());
    }

    private Polls returnPoll1 () {
        Polls poll = new Polls();
        poll.setId(1L);
        poll.setYesQuantity(1);
        poll.setNoQuantity(0);
        poll.setName("poll 1");
        return poll;
    }

    private Votes returnVote1Sim () {
        Votes vote = new Votes();
        vote.setPoll(returnPoll1());
        vote.setVote(VotesEnum.SIM);
        vote.setCpf("21172933014");
        vote.setId(1L);
        return vote;
    }

    private Votes returnVote1Nao () {
        Votes vote = new Votes();
        vote.setPoll(returnPoll1());
        vote.setVote(VotesEnum.NAO);
        vote.setCpf("21172933014");
        vote.setId(2L);
        return vote;
    }
}