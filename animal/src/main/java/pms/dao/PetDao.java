package pms.dao;

import java.util.List;

import pms.domain.Pet;

public interface PetDao {
	List<Pet> petList(int mno);
	
  Pet petSelectOne(int pno);
  
  void insert(Pet pet);
  
  int delete(int pno);
  
  int update(Pet pet);
}







