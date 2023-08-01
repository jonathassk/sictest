package com.example.demo.application.service;

import com.example.demo.application.repository.PollRepository;
import com.example.demo.domain.Polls;
import com.example.demo.infrastructure.exceptions.PollNotFoundException;
import com.example.demo.infrastructure.interfaces.PollService;
import com.example.demo.infrastructure.utils.PollDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PollServiceImp implements PollService {
    private final Logger logger = Logger.getLogger(PollServiceImp.class.getName());
    @Autowired
    private PollRepository pollRepository;

    @Override
    public Polls createPoll(int timeToEnd, String name) {
        if (timeToEnd < 1) {
            timeToEnd = 1;
        }
        Polls poll = new Polls();
        poll.setName(name);
        poll.setEndTime(PollDate.configureDate(timeToEnd));
        try {
            poll = pollRepository.save(poll);
            logger.info("[Create Poll] created poll id: " + poll.getId());
        } catch (Exception e) {
            logger.info("[CREATE POLL] error in creation of poll id: " + poll.getId() + " and name: " + poll.getName());
            logger.info(String.valueOf(e));
        }
        return poll;
    }

    @Override
    public List<Polls> getAllPolls() {
        List<Polls> polls = pollRepository.findAll();
        if (polls.isEmpty()) {
            logger.info("[Get Polls] there's no polls created!");
            throw new PollNotFoundException("Polls not found!");
        }
        return polls;
    }

    @Override
    public Optional<Polls> getPoll(Long pollId) {
        Optional<Polls> poll = pollRepository.findById(pollId);
        if (poll.isEmpty()) {
            logger.info("[Get Poll] Poll id: " + pollId + " not found!");
            throw new PollNotFoundException("Poll id: " + pollId + " not found!");
        }
        return poll;
    }
}
