package com.example.demo.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.models.enums.PackageStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "shipments")
public class Shipments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String receiverName;

	@Column(nullable = false)
	private int weightKg;

	@Column(nullable = false)
	private String boxColor;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country destinationCountry;
	
	@Column(nullable = false)
	private Long shipmentPrice;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date created_at;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PackageStatus packageStatus;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "shipment_id", referencedColumnName = "id")
	private Users user;
	
	@JsonIgnore
	public Users getUser() {
		return user;
	}

	@JsonIgnore
	public void setUser(Users user) {
		this.user = user;
	}

	public Long getBoxId() {
		return id;
	}

	public void setBoxId(Long boxId) {
		this.id = boxId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public int getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(int weightKg) {
		this.weightKg = weightKg;
	}

	public String getBoxColor() {
		return boxColor;
	}

	public void setBoxColor(String boxColor) {
		this.boxColor = boxColor;
	}

	public Country getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(Country destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public Long getShipmentPrice() {
		return shipmentPrice;
	}

	public void setShipmentPrice(Long shipmentPrice) {
		this.shipmentPrice = shipmentPrice;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public PackageStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageStatus packageStatus) {
		this.packageStatus = packageStatus;
	}
}
