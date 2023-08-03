package com.example.demo.domain;

import com.example.demo.infrastructure.utils.VotesEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Votes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "vote")
    private VotesEnum vote;

    @ManyToOne(optional = true)
    @JoinColumn(name = "poll_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference
    private Polls poll;
}
