package pms.service;

import java.util.List;

import pms.domain.Mating;

public interface MatingService {
	
	List<Mating> getMatingList();
  
  void addPet(Mating mating);
  
  int remove(int matNo);
  
  int change(Mating mating);
}







