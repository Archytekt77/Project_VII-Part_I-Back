package com.loicmaria.api.service;

import com.loicmaria.api.DTO.LoanDto;
import com.loicmaria.api.model.Loan;
import com.loicmaria.api.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl extends Services<Loan, LoanDto, LoanRepository> {

    @Override
    public Loan convertDtoToEntity(LoanDto loanDto){
        Loan loan = modelMapper.map(loanDto, Loan.class);
        return loan;
    }

    @Override
    public LoanDto convertEntityToDto(Loan loan){
        LoanDto loanDto = modelMapper.map(loan, LoanDto.class);
        return loanDto;
    }
}
