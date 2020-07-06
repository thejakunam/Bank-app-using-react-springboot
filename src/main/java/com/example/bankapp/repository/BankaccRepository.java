package com.example.bankapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.bankapp.model.Bankacc;

@Repository


public interface BankaccRepository extends MongoRepository<Bankacc, String>{
	
	List<Bankacc> findByUsername(String username);
	List<Bankacc> findByUserId(String userId);
	void deleteByBankaccno(String bankaccno);
	boolean existsByBankaccno(String bankaccno);
}
