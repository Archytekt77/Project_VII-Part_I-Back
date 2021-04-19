package com.loicmaria.api.service;

import com.loicmaria.api.DTO.RoleDto;
import com.loicmaria.api.model.Role;
import com.loicmaria.api.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends Services<Role, RoleDto, RoleRepository>{
    
    @Override
    public Role convertDtoToEntity(RoleDto roleDto){
        Role role = modelMapper.map(roleDto, Role.class);
        return role;
    }

    @Override
    public RoleDto convertEntityToDto(Role role){
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        return roleDto;
    }
}
