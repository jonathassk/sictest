package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Polls implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "yes_quantity")
    private int yesQuantity = 0;
    @Column(name = "no_quantity")
    private int noQuantity = 0;

    @OneToMany(mappedBy = "poll")
    private List<Votes> votes = new ArrayList<>();

}
