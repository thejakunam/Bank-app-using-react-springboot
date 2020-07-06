package com.example.bankapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.bankapp.model.Balance;


@Repository
public interface BalanceRepository extends MongoRepository<Balance,String> {
	
	List<Balance> findByUsername(String username);
	Balance findByBankaccno(String bankaccno);
}
