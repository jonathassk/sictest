package com.example.demo.infrastructure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PollDateTest {
    @Autowired
    private PollDate pollDate;

    @Test
    void verifyIfTimeReturnedIsRight() {
        int minutosDesejados = 60;
        LocalDateTime horaFutura = PollDate.configureDate(minutosDesejados);
        LocalDateTime horaEsperada = LocalDateTime.now().plusMinutes(minutosDesejados).withNano(0);
        // Verifica se o retorno está igual a 60 minutos a partir de agora
        Assertions.assertEquals(horaEsperada, horaFutura);
    }
}