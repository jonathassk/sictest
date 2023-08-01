package com.example.demo.application.repository;

import com.example.demo.domain.Votes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Votes, Long> {
}
