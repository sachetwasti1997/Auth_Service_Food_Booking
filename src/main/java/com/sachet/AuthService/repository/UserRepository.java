package com.sachet.AuthService.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.sachet.AuthService.models.User;

public interface UserRepository extends  ReactiveCrudRepository<User, String>{
  
}
