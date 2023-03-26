package com.exam.services;

import com.exam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserService implements IUser{
    @Autowired
    private final UserRepository UserRepository;
}
