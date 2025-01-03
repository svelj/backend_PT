package com.example.pockettrack.repository;

import com.example.pockettrack.model.Transaction;
import com.example.pockettrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByUser(User user);
    List<Transaction> findByUserId(Long userId);

}
