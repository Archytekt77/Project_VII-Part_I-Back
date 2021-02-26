package com.loicmaria.api.service;

import com.loicmaria.api.model.User;
import com.loicmaria.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends Services<User, UserRepository> {
}
