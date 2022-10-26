package com.example.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.models.enums.AccountRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = true)
	private String password;

	@Column
	private Date dateOfBirth;

	@Column
	private Country userCountry;

	@Column
	private String userZipCode; //has to be String for UK zipcodes (example: BA8) 

	@Column
	private String phoneNumber; //has to be String if we want to keep landlines (example +45 +44 in UK and Denmark)
	
	@Column
	private AccountRole accountRole;
	
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date created_at;


	public boolean findByEmail() {
		if (getEmail()==this.email) {
			return true;
		}else{
			return false;
		}
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Shipments> shipments;

    @JsonIgnore
    public Set<Shipments> getShipments() {
        return shipments;
    }
    
    @JsonIgnore
    public void setShipments(Set<Shipments> shipments) {
        this.shipments = shipments;
    }
    
	public Long getUserId() {
		return id;
	}


	public void setUserId(Long userId) {
		this.id = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Country getUserCountry() {
		return userCountry;
	}


	public void setUserCountry(Country userCountry) {
		this.userCountry = userCountry;
	}


	public String getUserZipCode() {
		return userZipCode;
	}


	public void setUserZipCode(String userZipCode) {
		this.userZipCode = userZipCode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public AccountRole getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}
	
	
}
