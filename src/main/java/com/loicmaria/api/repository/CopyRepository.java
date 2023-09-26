package com.loicmaria.api.repository;

import com.loicmaria.api.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Integer> {
    List<Copy> findByBook_Id(int id);
}
