package com.example.demo.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Long id;

	@Column(nullable = false)
	private String countryName;

	@Column(nullable = false)
	private Long feeMultiplier;

	@Column(nullable = false)
	private int countryCode;

    @OneToMany(mappedBy = "destinationCountry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Shipments> shipments;
	
	public Country() {

	}

	public Long getCountryId() {
		return id;
	}

	public void setCountryId(Long countryId) {
		this.id = countryId;
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
