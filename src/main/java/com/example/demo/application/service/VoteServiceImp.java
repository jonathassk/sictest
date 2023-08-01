package com.example.demo.application.service;

import com.example.demo.application.feign.CpfClient;
import com.example.demo.application.feign.config.CpfValidateClientConfig;
import com.example.demo.application.repository.PollRepository;
import com.example.demo.application.repository.VoteRepository;
import com.example.demo.domain.Polls;
import com.example.demo.domain.Votes;
import com.example.demo.infrastructure.exceptions.PollNotFoundException;
import com.example.demo.infrastructure.interfaces.VoteService;
import com.example.demo.infrastructure.utils.CpfVerifyDataClass;
import com.example.demo.infrastructure.utils.VotesEnum;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImp implements VoteService {

    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private VoteRepository voteRepository;

    private final EntityManager entityManager;

    public VoteServiceImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Polls addVote(String vote, String cpf, Long pollId) {
        Optional<Polls> poll = pollRepository.findById(pollId);
        if (poll.isEmpty()) throw new PollNotFoundException("poll not found, id: " + pollId);
        Votes voteResult = setVoteData(cpf, vote);
        Polls editedPoll = setVoteQuantity(voteResult, poll.get());

        voteResult.setPoll(editedPoll);
        editedPoll.getVotes().add(voteResult);
        entityManager.persist(vote);

        voteRepository.save(voteResult);
        return editedPoll;
    }

    private Polls setVoteQuantity (Votes vote, Polls poll) {
        if (vote.equals(VotesEnum.NAO.getVote())) {
            poll.setNoQuantity(poll.getNoQuantity() + 1);
        } else {
            poll.setYesQuantity(poll.getYesQuantity() + 1);
        }
        return poll;
    }

    private Votes setVoteData (String cpf, String vote) {
        Votes voteReturn = new Votes();
        if (verifyCpf(cpf).equals(Boolean.FALSE)) throw new IllegalArgumentException("document (CPF) is not valid!");
        voteReturn.setCpf(cpf);
        if (vote.equals(VotesEnum.NAO.getVote())) {
            voteReturn.setVote(VotesEnum.NAO);
        } else {
            voteReturn.setVote(VotesEnum.SIM);
        }
        return voteReturn;
    }

    private Boolean verifyCpf(String cpf) {
        CpfClient validCpfClient = CpfValidateClientConfig.verifyCpf("https://api.nfse.io/validate/NaturalPeople/taxNumber/");
        CpfVerifyDataClass validCpf = validCpfClient.validateCpf(cpf);
        return validCpf.isValid();
    }
}
