package com.example.bankapp.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.bankapp.model.Bankacc;
import com.example.bankapp.model.User;

@Repository
@Component
public interface UserRepository extends MongoRepository<User, String>{
	
	User findByUsername(String username);
	User findByUserId(String userId);

	  Boolean existsByUsername(String username);
}

