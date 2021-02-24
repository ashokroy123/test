package com.pack.PetApplication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pack.PetApplication.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	Optional<User> findByUsername(String username);
	
	User findByUsernameLike(String usernmae);

}
