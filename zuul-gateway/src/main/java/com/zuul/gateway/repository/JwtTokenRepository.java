package com.zuul.gateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zuul.gateway.bean.auth.JwtToken;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken, String> {

}
