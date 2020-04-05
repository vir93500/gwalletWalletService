package com.shashi.walletservice.Repository;

import com.shashi.walletservice.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "select * from transaction u where u.id = 1 ",nativeQuery = true)
    List<Transaction> findBysidAndrid(int sid);
}

