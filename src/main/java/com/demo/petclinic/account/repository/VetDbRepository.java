package com.demo.petclinic.account.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.petclinic.account.model.VetModel;

@Repository
public interface VetDbRepository extends MongoRepository<VetModel, String> {

	@Query(value = "{'name': {$regex : ?0, $options: 'i'},'dob': ?1}")
	List<VetModel> findByNameAndDob(String name, String dob);

	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	List<VetModel> findByName(String name);
	
}
