<<<<<<< HEAD
package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "country")
public class Country {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column   //@OneToMany(mappedBy = "destinationCountry")
	private String shipments;   //https://www.baeldung.com/hibernate-one-to-many - For testing
	
	
	@Column(nullable = false)
	private String country_name;
	
	
	@Column(nullable = false)
	private String zipcode;
	
	//Might need one more column for country pricing purposes, since scandinavia has lower than rest and
	//and we want to be able to +-/* in backend I think

}
=======
package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;

	@Column(nullable = false)
	private String countryName;

	@Column(nullable = false)
	private Long feeMultiplier;

	@Column(nullable = false)
	private int countryCode;

	public Country() {

	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getFeeMultiplier() {
		return feeMultiplier;
	}

	public void setFeeMultiplier(Long feeMultiplier) {
		this.feeMultiplier = feeMultiplier;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
}
>>>>>>> working-Endpoints
