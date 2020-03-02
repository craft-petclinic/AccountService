package com.demo.petclinic.account.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;
import com.demo.petclinic.account.repository.PetDbRepository;
import com.demo.petclinic.account.repository.VetDbRepository;
import com.demo.petclinic.account.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private PetDbRepository petRepository;

	@Autowired
	private VetDbRepository vetRepository;

	@Override
	public PetModel addPet(PetModel model) {
		return petRepository.save(model);
	}

	@Override
	public VetModel addVet(VetModel model) {
		return vetRepository.save(model);
	}

	@Override
	public List<PetModel> findPet(String petName, String dob) {
		if (!StringUtils.isEmpty(petName) && !StringUtils.isEmpty(dob)) {
			return petRepository.findByNameAndDob(petName, dob);
		}
		return null;
	}

	@Override
	public List<VetModel> findVet(String vetName) {
		if (!StringUtils.isEmpty(vetName)) {
			return vetRepository.findByName(vetName);
		}
		return null;
	}

	@Override
	public List<VetModel> getAllVet() {
		return vetRepository.findAll();
	}

	@Override
	public PetModel findPetByIdentifier(String petId) {
		Optional<PetModel> optional = petRepository.findById(petId);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public VetModel findVetByIdentifier(String vetId) {
		Optional<VetModel> optional = vetRepository.findById(vetId);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

}
