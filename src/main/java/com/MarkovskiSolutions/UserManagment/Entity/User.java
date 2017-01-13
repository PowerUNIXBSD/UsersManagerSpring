package com.MarkovskiSolutions.UserManagment.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "First name couldn't be empty!")
	@Size(max = 20, message = "First name can not exceed 20 characters!")
	@Column(name = "FIRSTNAME", nullable = false, length = 20)
	private String firstName;

	@NotNull(message = "Last name couldn't be empty!")
	@Size(max = 20, message = "Last name can not exceed 20 characters!")
	@Column(name = "LASTNAME", nullable = false, length = 20)
	private String lastName;

	@NotNull(message = "Date of birth couldn't be empty!")
	@Column(name = "DATEOFBIRTH", nullable = false)
	private Date dateOfBirth;

	@NotNull(message = "Phone number couldn't be empty!")
	@Size(max = 15, message = "Phone number can not exceed 15 characters!")
	@Column(name = "PHONENUMBER", nullable = false, length = 15)
	private String phoneNumber;

	@NotNull(message = "E-Mail address couldn't be empty!")
	@Size(max = 320, message = "E-Mail address can not exceed 320 characters")
	@Column(name = "EMAIL", nullable = false, length = 320)
	@Email(message = "E-Mail is not valid!")
	private String eMailAddress;

	public User() {
		
	}

	public User(Long id, String firstName, String lastName, Date dateOfBirth, String phoneNumber, String eMailAddress) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.eMailAddress = eMailAddress;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the eMailAddress
	 */
	public String getEMailAddress() {
		return eMailAddress;
	}

	/**
	 * @param eMailAddress
	 *            the eMailAddress to set
	 */
	public void setEMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}
}
