package com.binar.chapter6.service;

import com.binar.chapter6.model.Users;
import com.binar.chapter6.model.request.UsersRequest;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Users getUser();

    Users addUser (Users id);

    Users updateUser (UsersRequest usersRequest);

    void deleteUser (Integer id);

}
