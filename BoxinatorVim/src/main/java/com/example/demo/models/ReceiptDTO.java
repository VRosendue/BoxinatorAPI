package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.models.enums.PackageStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "countries")
public class ReceiptDTO {

	private String recipient;
	private Long weightKg;
	private String boxColor;
	private PackageStatus packageStatus;
	private String senderCountry;
	private String recipientCountry;

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Long getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(Long weightKg) {
		this.weightKg = weightKg;
	}

	public String getBoxColor() {
		return boxColor;
	}

	public void setBoxColor(String boxColor) {
		this.boxColor = boxColor;
	}

	public PackageStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageStatus packageStatus) {
		this.packageStatus = packageStatus;
	}

	public String getSenderCountry() {
		return senderCountry;
	}

	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}

	public String getRecipientCountry() {
		return recipientCountry;
	}

	public void setRecipientCountry(String recipientCountry) {
		this.recipientCountry = recipientCountry;
	}

	public ReceiptDTO(String recipient, Long weightKg, String boxColor, PackageStatus packageStatus,
			String senderCountry, String recipientCountry) {
		super();
		this.recipient = recipient;
		this.weightKg = weightKg;
		this.boxColor = boxColor;
		this.packageStatus = packageStatus;
		this.senderCountry = senderCountry;
		this.recipientCountry = recipientCountry;
	}

}
