package com.demo.petclinic.account.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;
import com.demo.petclinic.account.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private AccountController accountRestController;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AccountService accountService;

	@Test
	public void whenFindByAll_thenAllObjectsAreReturned() throws Exception {
		VetModel accountFirst = new VetModel();
		accountFirst.setId("id1");
		VetModel accountSecond = new VetModel();
		accountFirst.setId("id2");
		Mockito.when(accountService.getAllVet()).thenReturn(Arrays.asList(accountFirst, accountSecond));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/account/getAllVet").contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	public void whenFindByID_thenOneObjectsIsReturned() throws Exception {
		VetModel accountFirst = new VetModel();
		accountFirst.setId("id1");
		Mockito.when(accountService.findVetByIdentifier("id1")).thenReturn(accountFirst);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/account/getVetById/id1").contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	public void whenVetNullValue_thenReturns400() throws Exception {
		VetModel inputModelObj = new VetModel();
		// object validation will fail as mandatory fields is not there in object
		mockMvc.perform(MockMvcRequestBuilders.post("/api/account/addvet")
				.content(objectMapper.writeValueAsString(inputModelObj)).contentType("application/json"))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void whenPetNullValue_thenReturns400() throws Exception {
		PetModel inputModelObj = new PetModel();
		// object validation will fail as mandatory fields is not there in object
		mockMvc.perform(MockMvcRequestBuilders.post("/api/account/addpet")
				.content(objectMapper.writeValueAsString(inputModelObj)).contentType("application/json"))
				.andExpect(status().isBadRequest());

	}

}
