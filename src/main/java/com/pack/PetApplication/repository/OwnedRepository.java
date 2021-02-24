package com.pack.PetApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pack.PetApplication.model.Owned;

public interface OwnedRepository extends CrudRepository<Owned, Long>{
	
		@Query(value="select * from owned where cid=?1", nativeQuery = true)
		public List<Owned> findOwnedPets(long id);
}
