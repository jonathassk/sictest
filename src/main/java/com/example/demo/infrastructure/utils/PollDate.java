package com.example.demo.infrastructure.utils;

import java.time.LocalDateTime;

public class PollDate {

    public static LocalDateTime configureDate (int minutesToClose){
        return LocalDateTime.now().plusMinutes(minutesToClose).withNano(0);
    }
}
