package com.example.demo.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private int id;

	@Column(nullable = false)
	private String receiverName;

	@Column(nullable = false)
	private int weightKg;

	@Column(nullable = false)
	private String boxColor;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "country_name", nullable = false)
	@Column
	private String destinationCountry;
	
	@Column(nullable = false)
	private double price;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
}
