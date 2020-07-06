package com.example.bankapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.bankapp.model.Balance;
import com.example.bankapp.model.Bankacc;
import com.example.bankapp.model.User;
import com.example.bankapp.model.UserInfo;
import com.example.bankapp.repository.BalanceRepository;
import com.example.bankapp.repository.BankaccRepository;
import com.example.bankapp.repository.UserRepository;
import com.example.bankapp.repository.UserinfoRepository;

import io.jsonwebtoken.lang.Collections;

@Service
public class BankAppService {
	
	@Autowired
	private BankaccRepository bankaccrepo;
	@Autowired
	private BalanceRepository balancerepo;
	@Autowired
	private UserinfoRepository userinforepo;
	@Autowired
	private UserRepository userrepo;

	
	public List<Bankacc> getBankaccList(String username){
		
		List<Bankacc> bankaccList =  bankaccrepo.findByUsername(username);
		
		if(Collections.isEmpty(bankaccList)) {
			return null;
		}
		return bankaccList;
	}
	
	public List<Balance> getBalanceList(String username){
			
			List<Balance> balanceList =  balancerepo.findByUsername(username);
			
			if(Collections.isEmpty(balanceList)) {
				return null;
			}
			return balanceList;
		}

	public UserInfo getUserinfo(String username) {
		UserInfo userDetails = userinforepo.findByUsername(username);
		if(ObjectUtils.isEmpty(userDetails))
			return null;
		return userDetails;
	}
/*
	public void deleteAccount(String bankaccno) {
		bankaccrepo.deleteBybankaccno(bankaccno);
		
	}*/

	public Bankacc addAccount(Bankacc bankacc) {
		return bankaccrepo.save(new Bankacc(bankacc.getUserId(),bankacc.getBankaccno(), bankacc.getUsername(),bankacc.getBankname()));
		
	}

	public boolean exists(String bankaccno) {
		return bankaccrepo.existsByBankaccno(bankaccno);
	
	}



}
