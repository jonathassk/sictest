package com.example.demo.application.service;

import com.example.demo.application.repository.PollRepository;
import com.example.demo.domain.Polls;
import com.example.demo.infrastructure.exceptions.DateException;
import com.example.demo.infrastructure.interfaces.PollService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        Assertions.assertThrows(DateException.class, () -> pollService.createPoll(0, "Poll Name"));
    }

    @Test
    void testCreatePollSuccess() {
        MockitoAnnotations.openMocks(this);
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

}