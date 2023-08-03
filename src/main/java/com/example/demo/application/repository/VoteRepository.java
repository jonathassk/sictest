package com.example.demo.application.repository;

import com.example.demo.domain.Polls;
import com.example.demo.domain.Votes;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Votes, Long> {
    @Query("SELECT COUNT(v) FROM Votes v WHERE v.poll = :poll AND v.cpf = :cpf")
    int countVotesByPollAndCpf(@Param("poll") Polls poll, @Param("cpf") String cpf);
}
