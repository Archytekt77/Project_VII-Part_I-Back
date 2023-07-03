package com.loicmaria.api.repository;

import com.loicmaria.api.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    Collection<Loan> findByUser_IdAndStatus(int id, String status);
}
