package com.example.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankapp.model.Balance;
import com.example.bankapp.model.Bankacc;
import com.example.bankapp.model.UserInfo;
import com.example.bankapp.repository.UserRepository;
import com.example.bankapp.service.BankAppService;

import io.jsonwebtoken.lang.Collections;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bank")

public class BankAppController {
	
	@Autowired
	BankAppService bankservice;
	
	@GetMapping("/accounts")
	public ResponseEntity<?> getAccounts(@RequestParam("username") String username){
		if(StringUtils.isEmpty(username)) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		
		List<Bankacc> bankaccList = bankservice.getBankaccList(username);
		
		if(Collections.isEmpty(bankaccList)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bankaccList, HttpStatus.OK);
		
	}
	
	@GetMapping("/balance")
	public ResponseEntity<?> getBalance(@RequestParam("username") String username){
		if(StringUtils.isEmpty(username)) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		
		List<Balance> balanceList = bankservice.getBalanceList(username);
		
		if(Collections.isEmpty(balanceList)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(balanceList, HttpStatus.OK);
		
	}
	
	@GetMapping("/userinfo")
	public ResponseEntity<?> getUserinfo(@RequestParam("username") String username){
		if(StringUtils.isEmpty(username)) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		
		UserInfo userinfo = bankservice.getUserinfo(username);
		
		if(ObjectUtils.isEmpty(userinfo)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userinfo, HttpStatus.OK);
		
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<?> addBankAccount(@RequestBody Bankacc bankacc ){
		 try {
			 	Bankacc newbankacc = bankservice.addAccount(bankacc);
			    return new ResponseEntity<>(newbankacc, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			  }	
	}
	
	/*@DeleteMapping("/accounts/{bankaccno}")
	public ResponseEntity<?> deleteBankAccount(@PathVariable("bankaccno") String bankaccno ){
		try {
			bankservice.deleteAccount(bankaccno);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  } catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		  }
	}
	
	@PutMapping("/balance/{bankaccno}")
	public ResponseEntity<?> updateBalance(@PathVariable("bankaccno") String bankaccno, Balance balance){
		if(bankservice.exists(bankaccno)) {
			Bankacc newbankacc = bankservice.updateBalance(bankaccno,balance);
			return new ResponseEntity<>(newbankacc, HttpStatus.OK);
		}else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}*/
	
}
