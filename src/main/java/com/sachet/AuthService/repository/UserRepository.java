package com.sachet.AuthService.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.sachet.AuthService.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
  
}
