package com.demo.petclinic.account.services;

import java.util.List;

import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;

public interface AccountService {

	/**
	 * add pet to repository
	 * @param model object of {@link PetModel}
	 * @return {@link PetModel}
	 */
	public PetModel addPet(PetModel model);

	/**
	 * add vet to repository
	 * 
	 * @param model object of {@link VetModel}
	 * @return {@link VetModel}
	 */
	public VetModel addVet(VetModel model);

	/**
	 * find a pet by it's name and date of birth
	 * 
	 * @param petName pet name
	 * @param dob  date of birth of pet
	 * @return list of {@link PetModel}
	 */
	public List<PetModel> findPet(String petName, String dob);

	/**
	 * find list of vet whose name starts with name
	 * 
	 * @param vetName vet name
	 * @return list of {@link VetModel}
	 */
	public List<VetModel> findVet(String vetName);

	/**
	 * get all vets
	 * 
	 * @return @return list of {@link VetModel}
	 */
	public List<VetModel> getAllVet();

	/**
	 * find a pet by it's id
	 * 
	 * @param petId pet id
	 * @return {@link PetModel}
	 */
	public PetModel findPetByIdentifier(String petId);

	/**
	 * find a vet by it's id
	 * @param vetId vet id
	 * @return {@link VetModel}
	 */
	public VetModel findVetByIdentifier(String vetId);

}
