package com.zensar.gateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zensar.gateway.bean.JwtToken;


@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken, String> {

}
