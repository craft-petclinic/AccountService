package com.demo.petclinic.account.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.petclinic.account.model.PetModel;


@Repository
public interface PetDbRepository extends MongoRepository<PetModel, String> {
	
	
	List<PetModel> findByPnameAndPetDob(String petName, String perDob);

}
