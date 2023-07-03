package com.loicmaria.api.service;

import com.loicmaria.api.DTO.LoanDto;
import com.loicmaria.api.model.Loan;
import com.loicmaria.api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LoanServiceImpl extends Services<Loan, LoanDto, LoanRepository> {

    @Autowired
    UserServiceImpl userService;

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

    @Override
    public LoanDto save (LoanDto loanDto){
        Loan loan = this.convertDtoToEntity(loanDto);
        loan.setUser(this.userService.getLoggedUser());
        loanDto = this.convertEntityToDto(loan);
        return loanDto;
    }

    /**
     * <b>Retourne une liste de prêt en fonction de l'utilisateur connecté.</b>
     * @param id L'ID de l'utilisateur qui est connecté.
     * @param status Le status du prêt
     * @return Une liste de prêt.
     */
    public Collection<LoanDto> findByUserIdAndStatus(int id, String status){
        Collection<Loan> loanCollection = repository.findByUser_IdAndStatus(id, status);
        Collection<LoanDto> loanDtoCollection =  convertCollectionToDto(loanCollection);
        return loanDtoCollection;
    }
}
