package com.example.demo.application.service;

import com.example.demo.application.repository.PollRepository;
import com.example.demo.domain.Polls;
import com.example.demo.infrastructure.exceptions.PollNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


class PollServiceImpTest {

    @Mock
    private PollRepository pollRepository;

    @InjectMocks
    private PollServiceImp pollService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateTimeToEndLessThan1() {
        int timeToEnd = 0;
        String pollName = "Poll Name";
        LocalDateTime expectedEndTime = LocalDateTime.now().plusMinutes(1);

        Polls savedPoll = new Polls();
        savedPoll.setName(pollName);
        savedPoll.setEndTime(expectedEndTime);

        Mockito.when(pollRepository.save(Mockito.any(Polls.class))).thenReturn(savedPoll);

        Polls createdPoll = pollService.createPoll(timeToEnd, pollName);

        Assertions.assertEquals(pollName, createdPoll.getName());
        Assertions.assertEquals(expectedEndTime, createdPoll.getEndTime());
    }

    @Test
    void testCreatePollSuccess() {
        int timeToEnd = 10;
        String pollName = "Poll Name";
        LocalDateTime expectedEndTime = LocalDateTime.now().plusMinutes(timeToEnd);

        Polls savedPoll = new Polls();
        savedPoll.setName(pollName);
        savedPoll.setEndTime(expectedEndTime);

        Mockito.when(pollRepository.save(Mockito.any(Polls.class))).thenReturn(savedPoll);

        Polls createdPoll = pollService.createPoll(timeToEnd, pollName);

        Assertions.assertEquals(pollName, createdPoll.getName());
        Assertions.assertEquals(expectedEndTime, createdPoll.getEndTime());
    }

    @Test
    void testGetAllPollsSuccess() {
        Mockito.when(pollRepository.findAll()).thenReturn(List.of(returnPoll1(), returnPoll2()));

        List<Polls> resultFind = pollService.getAllPolls();

        Assertions.assertEquals(resultFind.get(0).getId(), returnPoll1().getId());
        Assertions.assertEquals(resultFind.get(1).getId(), returnPoll2().getId());
    }

    @Test
    void testGetAllWithFailure() {
        Mockito.when(pollRepository.findAll()).thenReturn(List.of());

        Assertions.assertThrows(PollNotFoundException.class, () -> pollService.getAllPolls());
    }

    @Test
    void testGetPollByIdSuccess() {
        Mockito.when(pollRepository.findById(1L)).thenReturn(Optional.of(returnPoll1()));

        Optional<Polls> resultFind = pollService.getPoll(1L);

        Assertions.assertEquals(resultFind.map(Polls::getId).orElseThrow(), returnPoll1().getId());
    }

    @Test
    void testGetPollByIdWithFailure() {
        Mockito.when(pollRepository.findById(3L)).thenReturn(Optional.empty());

        Assertions.assertThrows(PollNotFoundException.class, () -> pollService.getPoll(3L));
    }

    private Polls returnPoll1() {
        Polls poll = new Polls();
        poll.setId(1L);
        poll.setEndTime(LocalDateTime.now().plusMinutes(30));
        poll.setName("poll1");
        poll.setNoQuantity(10);
        poll.setYesQuantity(20);
        return poll;
    }

    private Polls returnPoll2() {
        Polls poll = new Polls();
        poll.setId(2L);
        poll.setEndTime(LocalDateTime.now().plusMinutes(30));
        poll.setName("poll2");
        poll.setNoQuantity(20);
        poll.setYesQuantity(30);
        return poll;
    }
}