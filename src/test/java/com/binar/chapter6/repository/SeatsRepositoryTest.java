package com.binar.chapter6.repository;

import com.binar.chapter6.model.Seats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SeatsRepositoryTest {

    @Autowired
    SeatsRepository seatsRepository;

    @Test
    void getStudioSeatTest() {
        List<Seats> test = seatsRepository.getStudioSeatStatus();
        Assertions.assertNotNull(test);
    }

}
