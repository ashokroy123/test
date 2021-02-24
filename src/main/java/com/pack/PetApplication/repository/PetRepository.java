package com.pack.PetApplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pack.PetApplication.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long>{
	
	List<Pet> findByName(String name);
}
