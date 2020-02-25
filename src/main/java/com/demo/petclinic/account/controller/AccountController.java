package com.demo.petclinic.account.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.petclinic.account.exceptionhandler.RecordNotFoundException;
import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;
import com.demo.petclinic.account.services.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/addpet")
	public ResponseEntity<PetModel> addPet(@Valid @RequestBody PetModel inputdata) {
		PetModel insertedData = accountService.addPet(inputdata);
		return new ResponseEntity<PetModel>(insertedData, HttpStatus.OK);
	}

	@PostMapping("/addvet")
	public ResponseEntity<VetModel> addVet(@Valid @RequestBody VetModel inputdata) {
		VetModel model = accountService.addVet(inputdata);
		return new ResponseEntity<VetModel>(model, HttpStatus.OK);
	}

	@GetMapping("/getAllVet")
	public List<VetModel> getAllVet() {
		return accountService.getAllVet();
	}

	@GetMapping("/findPet")
	public ResponseEntity<List<PetModel>> findPet(@RequestParam("name") String name, @RequestParam("dob") String dob) {

		List<PetModel> model = accountService.findPet(name, dob);
		if (model == null || model.size() == 0) {
			throw new RecordNotFoundException("pet not found with name :" + name + " and dob " + dob);
		}
		return new ResponseEntity<List<PetModel>>(model, HttpStatus.OK);
	}

	@GetMapping("/findVet")
	public ResponseEntity<List<VetModel>> findVet(@RequestParam("name") String name) {
		List<VetModel> models = accountService.findVet(name);
		if (models == null || models.size() == 0) {
			throw new RecordNotFoundException("vet not found with name :" + name);
		}
		return new ResponseEntity<List<VetModel>>(models, HttpStatus.OK);
	}

}
