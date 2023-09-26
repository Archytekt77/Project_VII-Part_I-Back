package com.loicmaria.api.service;

import com.loicmaria.api.DTO.CopyDto;
import com.loicmaria.api.model.Copy;
import com.loicmaria.api.repository.CopyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CopyServiceImpl extends Services<Copy, CopyDto, CopyRepository>{

    @Override
    public Copy convertDtoToEntity(CopyDto copyDto){
        Copy copy = modelMapper.map(copyDto, Copy.class);
        return copy;
    }

    @Override
    public CopyDto convertEntityToDto(Copy copy){
        CopyDto copyDto = modelMapper.map(copy, CopyDto.class);
        return copyDto;
    }

    public Collection<CopyDto> findByBook_Id(int id){
        Collection<Copy> copyCollection = repository.findByBook_Id(id);
        Collection<CopyDto> copyDtoCollection = convertCollectionToDto(copyCollection);
        return copyDtoCollection;
    }

}
