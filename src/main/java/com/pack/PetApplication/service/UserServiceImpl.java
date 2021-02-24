package com.pack.PetApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.PetApplication.model.User;
import com.pack.PetApplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User userAuthentication(User user) {
		Optional<User> optional= userRepository.findByUsername(user.getUsername());
		User databaseUser= null;
		System.out.println("Optional value is" + optional.get());
		if(optional.isPresent()) {
			databaseUser = optional.get();
			if(databaseUser.getPassword().equals(user.getPassword())) {
				return databaseUser;
			}
		}
		return null;
	}

}
