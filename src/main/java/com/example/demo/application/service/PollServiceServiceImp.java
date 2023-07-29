package com.example.demo.application.service;

import com.example.demo.domain.Poll;
import com.example.demo.infrastructure.interfaces.PollService;
import com.example.demo.infrastructure.utils.PollDate;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollServiceServiceImp implements PollService {
    private Logger logger;
    @Override
    public Poll createPoll(int timeToEnd, String name) {
        Poll poll = new Poll();

        poll.setName(name);
        poll.setNoQuantity(0);
        poll.setYesQuantity(0);
        poll.setEndTime(PollDate.configureDate(timeToEnd));
        try {

            logger.info("[Create Poll] created poll id: " + poll.getId());
        } catch (Exception e) {

        }

        return poll;
    }

    @Override
    public List<Poll> getAllPoll() {
        return null;
    }

    @Override
    public Poll getPoll(Long pollId) {
        return null;
    }
}
