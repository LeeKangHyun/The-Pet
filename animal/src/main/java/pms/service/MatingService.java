package pms.service;

import java.util.List;

import pms.domain.Mating;

public interface MatingService {
	
	List<Mating> getMatingList(int pageNo);
  
	Mating getMatingOne(int matNo);
	
  void addPet(Mating mating);
  
  int remove(int matNo);
  
  int change(Mating mating);
  
  void addviews(int matNo);
}







