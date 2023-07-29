package com.example.demo.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;

    private String vote;

    private List<Poll> enquetes;
}
