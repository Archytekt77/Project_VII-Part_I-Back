package com.loicmaria.api.service;

import com.loicmaria.api.DTO.UserDto;
import com.loicmaria.api.model.User;
import com.loicmaria.api.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends Services<User, UserDto, UserRepository>{

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
}
