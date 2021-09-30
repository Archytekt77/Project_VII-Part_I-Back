package com.loicmaria.api.service;

import com.loicmaria.api.DTO.UserDto;
import com.loicmaria.api.model.User;
import com.loicmaria.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends Services<User, UserDto, UserRepository>{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public User convertDtoToEntity(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    @Override
    public UserDto convertEntityToDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto save(UserDto userDto){
        User user = this.convertDtoToEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        userDto = this.convertEntityToDto(user);

        return userDto;
    }



    public User findByUsername(String username){
        return this.repository.findByUsername(username);
    }

}
