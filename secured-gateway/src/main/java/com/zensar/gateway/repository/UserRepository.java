package com.zensar.gateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zensar.gateway.bean.User;


public interface UserRepository extends MongoRepository<User, String>{
	@Query(value="{'email' : ?0}")
	User findByEmail(String email);
}
