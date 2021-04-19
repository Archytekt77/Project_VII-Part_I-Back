package com.loicmaria.api.service;

import com.loicmaria.api.DTO.TypeDto;
import com.loicmaria.api.model.Type;
import com.loicmaria.api.repository.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends Services<Type, TypeDto, TypeRepository>{

    @Override
    public Type convertDtoToEntity(TypeDto typeDto){
        Type type = modelMapper.map(typeDto, Type.class);
        return type;
    }

    @Override
    public TypeDto convertEntityToDto(Type type){
        TypeDto typeDto = modelMapper.map(type, TypeDto.class);
        return typeDto;
    }
}
