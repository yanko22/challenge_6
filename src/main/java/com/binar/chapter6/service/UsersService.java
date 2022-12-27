package com.binar.chapter6.service;

import com.binar.chapter6.model.Users;
import com.binar.chapter6.model.request.UsersRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    List<Users> getUser();

    Users addUser (Users id);

    void updateUser (UsersRequest usersRequest);

    void deleteUser (Integer id);

}
