package com.demo.petclinic.account.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.petclinic.account.errorhandler.RecordNotFoundException;
import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;
import com.demo.petclinic.account.services.AccountService;
import com.google.gson.Gson;

/**
 * a rest api controller which provides api to manage pet and vet account
 * 
 * @author sarveshkumar
 *
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	/**
	 * add pet
	 * 
	 * @param inputdata {@link PetModel}
	 * @return http status with {@link PetModel}
	 */
	@PostMapping("/addpet")
	public ResponseEntity<PetModel> addPet(@Valid @RequestBody PetModel inputdata) {
		LOG.info("input data for pet registration is " + new Gson().toJson(inputdata));
		PetModel insertedData = accountService.addPet(inputdata);
		return new ResponseEntity<PetModel>(insertedData, HttpStatus.OK);
	}

	/**
	 * add vet
	 * 
	 * @param inputdata {@link VetModel}
	 * @return http status with {@link VetModel}
	 */
	@PostMapping("/addvet")
	public ResponseEntity<VetModel> addVet(@Valid @RequestBody VetModel inputdata) {
		LOG.info("input data for vet registration is " + new Gson().toJson(inputdata));
		VetModel model = accountService.addVet(inputdata);
		return new ResponseEntity<VetModel>(model, HttpStatus.OK);
	}

	/**
	 * get pet by it's id
	 * 
	 * @param petId pet id
	 * @return http status with {@link PetModel}
	 */
	@GetMapping("/getPetById/{petId}")
	public ResponseEntity<PetModel> getPetById(@PathVariable("petId") @NotBlank String petId) {
		PetModel petModel = accountService.findPetByIdentifier(petId);
		if (petModel == null) {
			throw new RecordNotFoundException("No Vet Found");
		}
		return new ResponseEntity<PetModel>(petModel, HttpStatus.OK);
	}

	/**
	 * get vet by it's id
	 * 
	 * @param vetId vet id
	 * @return http status with {@link VetModel}
	 */
	@GetMapping("/getVetById/{vetId}")
	public ResponseEntity<VetModel> getVetById(@PathVariable("vetId") @NotBlank String vetId) {
		VetModel vetModel = accountService.findVetByIdentifier(vetId);
		if (vetModel == null) {
			throw new RecordNotFoundException("No Vet Found");
		}
		return new ResponseEntity<VetModel>(vetModel, HttpStatus.OK);

	}

	/**
	 * get all vet
	 * 
	 * @return List of {@link VetModel}
	 */
	@GetMapping("/getAllVet")
	public ResponseEntity<List<VetModel>> getAllVet() {
		List<VetModel> vetList = accountService.getAllVet();
		if (vetList == null || vetList.size() == 0) {
			throw new RecordNotFoundException("No Vet Found");
		}
		return new ResponseEntity<List<VetModel>>(vetList, HttpStatus.OK);
	}

	/**
	 * find pet by it's name and date of birth
	 * 
	 * @param name name of pet
	 * @param dob  date of birth of pet
	 * @return List of {@link PetModel}
	 */
	@GetMapping("/getPet")
	public ResponseEntity<List<PetModel>> findPet(@RequestParam("name") @NotBlank String name,
			@RequestParam("dob") @NotBlank String dob) {

		List<PetModel> model = accountService.findPet(name, dob);
		if (model == null || model.size() == 0) {
			throw new RecordNotFoundException("No Pet Found");
		}
		return new ResponseEntity<List<PetModel>>(model, HttpStatus.OK);
	}

	/**
	 * get vet by name
	 * 
	 * @param name name of vet
	 * @return List of {@link VetModel}
	 */
	@GetMapping("/getVetByName")
	public ResponseEntity<List<VetModel>> findVet(@RequestParam("name") @NotBlank String name) {
		List<VetModel> models = accountService.findVet(name);
		if (models == null || models.size() == 0) {
			throw new RecordNotFoundException("No Vet Found");
		}
		return new ResponseEntity<List<VetModel>>(models, HttpStatus.OK);
	}

}
