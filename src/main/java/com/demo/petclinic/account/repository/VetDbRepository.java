package com.demo.petclinic.account.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.petclinic.account.model.VetModel;

@Repository
public interface VetDbRepository extends MongoRepository<VetModel, String> {

	List<VetModel> findByNameAndDob(String name, String dob);

	List<VetModel> findByName(String name);

}
