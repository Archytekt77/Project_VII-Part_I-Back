package com.loicmaria.api.controller;

import com.loicmaria.api.DTO.LoanDto;
import com.loicmaria.api.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Loans")
public class LoanController {

    @Autowired
    LoanServiceImpl loanService;

    /**
     * Create - Add a new loan
     *
     * @param loanDto An object loan
     * @return The loan object saved
     */
    @PostMapping
    public LoanDto createLoan(@RequestBody LoanDto loanDto) {
        return loanService.save(loanDto);
    }


    /**
     * Read - Get one loan
     *
     * @param id The id of the loan
     * @return An Loan object full filled
     */
    @GetMapping("/{id}")
    public LoanDto getLoan(@PathVariable("id") int id) {
        LoanDto loanDto = loanService.get(id);
        return loanDto;
    }

    /**
     * Read - Get all loans
     *
     * @return - An Iterable object of Loan full filled
     */
    @GetMapping
    public Collection<LoanDto> getLoans() {
        return loanService.getter();
    }

    /**
     * Update - Update an existing loan
     *
     * @param id   - The id of the loan to update
     * @param loanDto - The loan object updated
     * @return The currentLoan if he is present or null
     */
    @PutMapping("/{id}")
    public LoanDto updateLoan(@PathVariable("id") int id, @RequestBody LoanDto loanDto) {
        loanService.save(loanDto);
        return loanDto;
    }


    /**
     * Delete - Delete an loan
     *
     * @param id - The id of the loan to delete
     */
    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable("id") int id) {
        loanService.delete(id);
    }
}
