package com.loicmaria.api.service;

import com.loicmaria.api.DTO.UserDto;
import com.loicmaria.api.model.Role;
import com.loicmaria.api.model.User;
import com.loicmaria.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl extends Services<User, UserDto, UserRepository>{


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImpl roleService;

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
        Role role = this.roleService.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoleList(roles);
        userRepository.save(user);
        userDto = this.convertEntityToDto(user);

        return userDto;
    }


    /**
     * <b>Récupérer un utilisateur avec son peudo</b>
     * @param username Pseudo
     * @return L'utilisateur correspondant au pseudo.
     */
    public UserDto findByUsername(String username){
        User user = this.repository.findByUsername(username);
        UserDto userDto = this.convertEntityToDto(user);
        return userDto;
    }


}
