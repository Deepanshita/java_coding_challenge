package com.model;

public class Dog extends Pet{
	private int dogId;
	private String dogBreed;
	private int PetId;

	public Dog() {
		super();
	}

	public Dog(int dogId, String dogBreed) {
		super();
		this.dogId = dogId;
		this.dogBreed = dogBreed;
	}

	

	public Dog(String dogBreed) {
		super();
		this.dogBreed = dogBreed;
	}

	public Dog(String dogBreed, int petId) {
		super();
		this.dogBreed = dogBreed;
		this.PetId = petId;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}

	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", dogBreed=" + dogBreed + "]";
	}
}