package com.zuul.gateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zuul.gateway.bean.auth.User;

public interface UserRepository extends MongoRepository<User, String>{
	@Query(value="{'email' : ?0}")
	User findByEmail(String email);
}
