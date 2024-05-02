package com.model;

public class Donation {
	private int donorId;
	private String donorName;
	private int petId;
	
	public Donation() {
		super();
	}

	public Donation(int donorId, String donorName, int petId) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.petId = petId;
	}

	public Donation(String donorName2, int petId2) {
		// TODO Auto-generated constructor stub
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "Donation [donorId=" + donorId + ", donorName=" + donorName + ", petId=" + petId + "]";
	}
}
