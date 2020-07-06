package com.example.bankapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.bankapp.model.UserInfo;

@Repository
public interface UserinfoRepository extends MongoRepository<UserInfo,String> {

	UserInfo findByUsername(String username);
	UserInfo findByUserId(String userId);

}
