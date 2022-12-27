package com.binar.chapter6.repository;

import com.binar.chapter6.model.Films;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FilmsRepositoryTest {
    @Autowired
    FilmsRepository filmsRepository;

    @Test
    void getAllFilms() {
        List<Films> test = filmsRepository.getAllFilms();
        Assertions.assertNotNull(test);
    }

    @Test
    void addFilms() {
        Films films = new Films();
        films.setFilmCode(1001);
        films.setFilmName("Attack on Weebs");
        films.setPlaying(true);
        filmsRepository.save(films);
    }

    @Test
    void addFilms1() {
        Films films = new Films();
        films.setFilmCode(1002);
        films.setFilmName("Waifu Wars");
        films.setPlaying(true);
        filmsRepository.save(films);
    }

    @Test
    void addFilms2() {
        Films films = new Films();
        films.setFilmCode(1003);
        films.setFilmName("Isekai Jokowi");
        films.setPlaying(true);
        filmsRepository.save(films);
    }

    @Test
    void addFilms3() {
        Films films = new Films();
        films.setFilmCode(1004);
        films.setFilmName("Daily Life of Puan-Chan");
        films.setPlaying(true);
        filmsRepository.save(films);
    }
}

