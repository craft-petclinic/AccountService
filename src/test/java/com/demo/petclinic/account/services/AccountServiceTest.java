package com.demo.petclinic.account.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.petclinic.account.model.PetModel;
import com.demo.petclinic.account.model.VetModel;
import com.demo.petclinic.account.repository.PetDbRepository;
import com.demo.petclinic.account.repository.VetDbRepository;
import com.demo.petclinic.account.services.impl.AccountServiceImpl;


/**
 * Junit test class for account service
 * @author sarveshkumar
 *
 */
@RunWith(SpringRunner.class)
public class AccountServiceTest {

	@MockBean
	PetDbRepository petRepository;

	@MockBean
	VetDbRepository vetRepository;

	@TestConfiguration
	static class AccountServiceTestConfiguration {
		@Bean
		public AccountService appointmentService() {
			return new AccountServiceImpl();
		}
	}

	@Autowired
	private AccountService accountService;

	@Test
	public void verifyFindByPetId() {
		PetModel model = accountService.findPetByIdentifier("id2");
		assertNotNull(model);
		assertEquals("testuser2", model.getName());
	}

	@Test
	public void verifyGetPetByNameAndDOb() {
		List<PetModel> model = accountService.findPet("testuser1", "01/01/2019");
		assertEquals(1, model.size());
		assertEquals("owner2", model.get(0).getOwnerFirstName());

		List<PetModel> emptyModel = accountService.findPet("invalid", "01/02/2019");
		assertEquals(0, emptyModel.size());

	}

	@Test
	public void verifyFindByVetId() {
		VetModel model = accountService.findVetByIdentifier("id3");
		assertNotNull(model);
		assertEquals("testuser3", model.getName());
	}

	@Test
	public void verifyFindByVetName() {
		List<VetModel> emptyModels = accountService.findVet("invalid");
		assertEquals(0, emptyModels.size());

		List<VetModel> models = accountService.findVet("testuser2");
		assertEquals(1, models.size());

	}

	@Test
	public void verifyGetAllVet() {
		List<VetModel> models = accountService.getAllVet();
		assertEquals(models.size(), 3);
	}

	@Before
	public void setUpVet() {

		VetModel accountFirst = new VetModel();
		accountFirst.setId("id1");
		accountFirst.setName("testuser1");
		accountFirst.setDob("01/01/2019");
		accountFirst.setEmailId("user1@gmail.com");
		accountFirst.setGender("male");
		accountFirst.setContact("1234567891");

		VetModel accountSecond = new VetModel();
		accountSecond.setId("id2");
		accountSecond.setName("testuser2");
		accountSecond.setDob("01/02/2019");
		accountSecond.setEmailId("user2@gmail.com");
		accountSecond.setGender("male");
		accountSecond.setContact("1234567891");

		VetModel accountThird = new VetModel();
		accountThird.setId("id3");
		accountThird.setName("testuser3");
		accountThird.setDob("01/03/2019");
		accountThird.setEmailId("user3@gmail.com");
		accountThird.setGender("male");
		accountThird.setContact("1234567891");

		List<VetModel> allVet = Arrays.asList(accountFirst, accountSecond, accountThird);

		Mockito.when(vetRepository.findAll()).thenReturn(allVet);
		Mockito.when(vetRepository.findByName("testuser2")).thenReturn(Arrays.asList(accountSecond));
		Mockito.when(vetRepository.findByName("invalid")).thenReturn(new ArrayList<VetModel>());
		Mockito.when(vetRepository.findById("id3")).thenReturn(Optional.of(accountThird));
	}

	@Before
	public void setUpPet() {

		PetModel accountFirst = new PetModel();
		accountFirst.setId("id1");
		accountFirst.setName("testuser1");
		accountFirst.setDob("01/01/2019");
		accountFirst.setEmailId("user1@gmail.com");
		accountFirst.setOwnerFirstName("owner1");

		PetModel accountSecond = new PetModel();
		accountSecond.setId("id2");
		accountSecond.setName("testuser2");
		accountSecond.setDob("01/02/2019");
		accountSecond.setEmailId("user2@gmail.com");
		accountSecond.setOwnerFirstName("owner2");

		List<PetModel> allPet = Arrays.asList(accountFirst, accountSecond);

		Mockito.when(petRepository.findAll()).thenReturn(allPet);
		Mockito.when(petRepository.findByNameAndDob("testuser1", "01/01/2019"))
				.thenReturn(Arrays.asList(accountSecond));
		Mockito.when(petRepository.findByNameAndDob("invalid", "01/02/2019")).thenReturn(new ArrayList<PetModel>());
		Mockito.when(petRepository.findById("id2")).thenReturn(Optional.of(accountSecond));
	}

}
