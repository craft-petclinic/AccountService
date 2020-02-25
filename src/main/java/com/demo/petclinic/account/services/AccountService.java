package com.demo.petclinic.account.services;

import java.util.List;

import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;

public interface AccountService {

	/**
	 * 
	 * @param model
	 * @return
	 */
	public PetModel addPet(PetModel model);

	/**
	 * 
	 * @param model
	 * @return
	 */
	public VetModel addVet(VetModel model);

	/**
	 * 
	 * @param petName
	 * @param dob
	 * @return
	 */
	public List<PetModel> findPet(String petName, String dob);

	/**
	 * 
	 * @param vetName
	 * @param dob
	 * @return
	 */
	public List<VetModel> findVet(String vetName);
	
	/**
	 * 
	 * @param vetName
	 * @param dob
	 * @return
	 */
	public List<VetModel> getAllVet();
	

}
