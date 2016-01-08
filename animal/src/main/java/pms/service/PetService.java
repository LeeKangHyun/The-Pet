package pms.service;

import java.util.List;

import pms.domain.Pet;



public interface PetService {
	
	List<Pet> getPetList(int mno);
	
  Pet getOnePet(int pno);
  
  void add(Pet pet);
  
  int remove(int pno);
  
  int change(Pet pet);
}







