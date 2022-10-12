package com.example.demo.models;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private Long userId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column
	private String dateOfBirth;

	@Column
	private String userCountry;

	@Column
	private String userZipCode; //has to be String for UK zipcodes (example: BA8) 

	@Column
	private String phoneNumber; //has to be String if we want to keep landlines (example +45 +44 in UK and Denmark)
	
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date created_at;

}
