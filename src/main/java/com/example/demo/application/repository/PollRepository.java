package com.example.demo.application.repository;

import com.example.demo.domain.Polls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Polls, Long> {

}
