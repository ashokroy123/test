package com.pack.PetApplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.PetApplication.model.Owned;
import com.pack.PetApplication.model.Pet;
import com.pack.PetApplication.model.User;
import com.pack.PetApplication.repository.OwnedRepository;
import com.pack.PetApplication.repository.PetRepository;
import com.pack.PetApplication.repository.UserRepository;
import com.pack.PetApplication.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PetController {

	@Autowired
	PetRepository repository;

	@Autowired
	OwnedRepository repo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);

	@PostMapping(value = "/users/user")
	public ResponseEntity<User> petUserAutentication(@RequestBody User user) {
    	LOGGER.info("User details captured from angular");
		User user1 = userService.userAuthentication(user);
		try {
			return new ResponseEntity<>(user1, HttpStatus.CREATED);
		} catch (Exception e) {
			User invalid = new User();
			return new ResponseEntity<>(invalid, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/pets/{cid}")
	public ResponseEntity<Pet> postPet(@RequestBody Pet pet, @PathVariable int cid) {
		LOGGER.info("Adding pet details into the database");
		try {
			Pet p1 = new Pet(pet.getName(), pet.getBreed(), pet.getDob(), pet.getPrice(), pet.getGender());
			p1.setCid(cid);
			p1.setStatus("Available");
			Pet _pet = repository.save(p1);
			return new ResponseEntity<>(_pet, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> postUser(@RequestBody User userModal) {
		LOGGER.info("Adding user details into the database");
		try {
			User dbUser = userRepo.findByUsernameLike(userModal.getUsername());
			if (dbUser == null) {
				User u1 = new User(userModal.getUsername(), userModal.getPassword(), userModal.getConfirmPassword());
				User _user = userRepo.save(u1);
				return new ResponseEntity<>(_user, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null,HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/pets")
	public ResponseEntity<List<Pet>> getAllPets() {
		LOGGER.info("Fetching all pets from the database");
		List<Pet> pets = new ArrayList<Pet>();
		try {
			repository.findAll().forEach(pets::add);
			if (pets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pets, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pets/{pid}/{cid}")
	public ResponseEntity<Pet> getPetById(@PathVariable("pid") long pid, @PathVariable("cid") long cid) {
		LOGGER.info("Fetching pet by using pet id and saving that pet into owned table");
		Optional<Pet> petData = repository.findById(pid);
		if (petData.isPresent()) {
			Pet pet = petData.get();
			pet.setStatus("SoldOut");
			repository.save(pet);
			Owned sold = new Owned(pet.getPid(), pet.getName(), pet.getDob(), pet.getBreed(), pet.getGender());
			sold.setCid(cid);
			repo.save(sold);
			return new ResponseEntity<>(pet, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pets/owned/{cid}")
	public ResponseEntity<List<Owned>> getOwnedPets(@PathVariable long cid) {
		LOGGER.info("Fetching the list of owned pets");
		List<Owned> petsOwned = new ArrayList<Owned>();
		try {
			repo.findOwnedPets(cid).forEach(petsOwned::add);
			if (petsOwned.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(petsOwned, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "pets/name/{name}")
	public ResponseEntity<List<Pet>> findByPetName(@PathVariable String name) {
		LOGGER.info("Fetching pet by using pet name");
		try {
			List<Pet> pets = repository.findByName(name);
			if (pets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pets, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
