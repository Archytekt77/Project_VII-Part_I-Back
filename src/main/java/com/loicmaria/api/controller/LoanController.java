package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.LoanDto;
import com.loicmaria.api.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanServiceImpl loanService;

    //      CRUD
    //----------------------------------------------------------------------------------------------------------------

    /**
     * Create - Add a new loan
     *
     * @param loanDto An object loan
     * @return ResponseEntity.ok
     */
    @PostMapping("/create")
    public ResponseEntity<?> createLoan(@RequestBody LoanDto loanDto) {
        return ResponseEntity.ok(loanService.save(loanDto));
    }

    /**
     * Read - Get one loan
     *
     * @param id The id of the loan
     * @return An Loan object full filled
     */
    @GetMapping("/id/{id}")
    public LoanDto getLoan(@PathVariable("id") int id) {
        LoanDto loanDto = loanService.get(id);
        return loanDto;
    }

    /**
     * Read - Get all loans
     *
     * @return - An Iterable object of Loan full filled
     */
    @GetMapping("/all")
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
    @PutMapping("/id/{id}")
    public LoanDto updateLoan(@PathVariable("id") int id, @RequestBody LoanDto loanDto) {
        loanService.save(loanDto);
        return loanDto;
    }

    /**
     * Delete - Delete an loan
     *
     * @param id - The id of the loan to delete
     */
    @DeleteMapping("/id/{id}")
    public void deleteLoan(@PathVariable("id") int id) {
        loanService.delete(id);
    }

    //----------------------------------------------------------------------------------------------------------------


    @GetMapping("/by_user_id")
    public Collection<LoanDto> getLoansByUser(@PathVariable("id") int id, String status){
        Collection<LoanDto> loanDtoCollection = loanService.findByUserIdAndStatus(id, status);
        return loanDtoCollection;
    }



}
