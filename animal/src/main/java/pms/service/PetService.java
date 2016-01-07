package pms.service;

import pms.domain.Pet;



public interface PetService {
	
  Pet getOnePet(int pno);
  
  void add(Pet pet);
  
  int remove(int pno);
  
  int change(Pet pet);
}







