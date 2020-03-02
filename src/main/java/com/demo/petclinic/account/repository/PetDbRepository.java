package com.demo.petclinic.account.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.petclinic.account.model.PetModel;

@Repository
public interface PetDbRepository extends MongoRepository<PetModel, String> {

	@Query(value = "{'name': {$regex : ?0, $options: 'i'},'dob': ?1}")
	List<PetModel> findByNameAndDob(String name, String dob);

}
