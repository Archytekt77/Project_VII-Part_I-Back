package com.loicmaria.api.controller;

import com.loicmaria.api.model.Loan;
import com.loicmaria.api.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Loan")
public class LoanController {
    
    @Autowired
    LoanServiceImpl loanService;

    /**
     * Create - Add a new loan
     * @param loan An object loan
     * @return The loan object saved
     */
    @PostMapping("/loan")
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.save(loan);
    }


    /**
     * Read - Get one loan 
     * @param id The id of the loan
     * @return An Loan object full filled
     */
    @GetMapping("/loan/{id}")
    public Loan getLoan(@PathVariable("id") int id) {
        Optional<Loan> loan = loanService.get(id);
        if(loan.isPresent()) {
            return loan.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all loans
     * @return - An Iterable object of Loan full filled
     */
    @GetMapping("/loans")
    public Iterable<Loan> getLoans() {
        return loanService.getter();
    }

    /**
     * Update - Update an existing loan
     * @param id - The id of the loan to update
     * @param loan - The loan object updated
     * @return The currentLoan if he is present or null
     */
    @PutMapping("/loan/{id}")
    public Loan updateLoan(@PathVariable("id") int id, @RequestBody Loan loan) {
        Optional<Loan> e = loanService.get(id);
        if(e.isPresent()) {
            Loan currentLoan = e.get();

            String status = loan.getStatus();
            if(status != null) {
                currentLoan.setStatus(status);
            }
            loanService.save(currentLoan);
            return currentLoan;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an loan
     * @param id - The id of the loan to delete
     */
    @DeleteMapping("/loan/{id}")
    public void deleteLoan(@PathVariable("id") int id) {
        loanService.delete(id);
    }
}
