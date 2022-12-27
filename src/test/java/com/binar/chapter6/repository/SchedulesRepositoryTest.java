package com.binar.chapter6.repository;

import com.binar.chapter6.model.Schedules;
import com.binar.chapter6.service.FilmsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SchedulesRepositoryTest {
    @Autowired
    SchedulesRepository schedulesRepository;
    @Autowired
    FilmsServiceImpl filmsServiceImpl;

    @Test
    void getSchedules() {
        List<Schedules> test = schedulesRepository.getSchedules();
        Assertions.assertNotNull(test);
    }

    @Test
    void addSchedule() {
        Schedules schedules = new Schedules();
        schedules.setScheduleId(1010);
        schedules.setFilmCode(1001);
        schedules.setPlayingDate("01 November 2022");
        schedules.setStartingTime("12:00");
        schedules.setEndingTime("15:00");
        schedules.setTicketPrice(50000);
        schedulesRepository.save(schedules);
    }

    @Test
    void addSchedule1() {
        Schedules schedules = new Schedules();
        schedules.setScheduleId(1020);
        schedules.setFilmCode(1002);
        schedules.setPlayingDate("02 November 2022");
        schedules.setStartingTime("12:00");
        schedules.setEndingTime("15:00");
        schedules.setTicketPrice(50000);
        schedulesRepository.save(schedules);
    }
}
