package com.binar.chapter6.repository;

import com.binar.chapter6.model.Users;
import com.binar.chapter6.service.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersServiceImpl usersServiceImpl;

    @Test
    void addUsersTest1() {
        Users users = new Users();
        users.setId(101);
        users.setUsername("leona");
        users.setEmail("leona@gmail.com");
        users.setPassword("leonaajah123");
        usersRepository.save(users);
    }

    @Test
    void addUsersTest2() {
        Users users1 = new Users();
        users1.setId(102);
        users1.setUsername("jokowi");
        users1.setEmail("jokowi@gmail.com");
        users1.setPassword("jokowiajah123");
        usersRepository.save(users1);
    }
}
