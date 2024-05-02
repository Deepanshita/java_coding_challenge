package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PetDao;
import com.dao.PetDaoImpl;
import com.exception.InvalidPetAgeException;
import com.model.Pet;

public class PetService {
	PetDao petDao = new PetDaoImpl();

	public int save(Pet pet) throws SQLException{
		return petDao.addPet(pet);
	}

	public List<Pet> getAllPets() throws SQLException {
		return petDao.getAllPets();
	}

	public int removePetById(int petId) throws SQLException {
		return petDao.removePetById(petId);
	}

	public List<Pet> getAllAvailablePets() throws SQLException {
		return petDao.getAllAvailablePets();
	}
}