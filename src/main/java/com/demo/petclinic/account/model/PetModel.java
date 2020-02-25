package com.demo.petclinic.account.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("petcollection")
public class PetModel {

	@Id
	private String id;

	@NotBlank(message = "name must not be empty")
	private String pname;
	private String pspecies;
	private String pbreed;
	@NotBlank(message = "DOB must not be empty")
	private String petDob;
	private String gender;
	private String color;

	@NotBlank(message = "owner first name must not be empty")
	private String ofname;
	private String olname;
	@NotBlank(message = "Address : street must not be empty")
	private String street;
	@NotBlank(message = "Address : city must not be empty")
	private String city;
	@NotEmpty(message = "Address : state must not be empty")
	private String state;
	@NotEmpty(message = "Address : country must not be empty")
	private String country;
	@NotEmpty(message = "Address : postl code must not be empty")
	private String postalCode;
	private String contact;
	@NotBlank(message = "Email can not be empty")
	@Email(message = "email should be a valid email")
	private String emailId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the pspecies
	 */
	public String getPspecies() {
		return pspecies;
	}

	/**
	 * @param pspecies the pspecies to set
	 */
	public void setPspecies(String pspecies) {
		this.pspecies = pspecies;
	}

	/**
	 * @return the pbreed
	 */
	public String getPbreed() {
		return pbreed;
	}

	/**
	 * @param pbreed the pbreed to set
	 */
	public void setPbreed(String pbreed) {
		this.pbreed = pbreed;
	}

	/**
	 * @return the petDob
	 */
	public String getPetDob() {
		return petDob;
	}

	/**
	 * @param petDob the petDob to set
	 */
	public void setPetDob(String petDob) {
		this.petDob = petDob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the ofname
	 */
	public String getOfname() {
		return ofname;
	}

	/**
	 * @param ofname the ofname to set
	 */
	public void setOfname(String ofname) {
		this.ofname = ofname;
	}

	/**
	 * @return the olname
	 */
	public String getOlname() {
		return olname;
	}

	/**
	 * @param olname the olname to set
	 */
	public void setOlname(String olname) {
		this.olname = olname;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
