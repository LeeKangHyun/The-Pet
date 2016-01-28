package pms.service;

import java.util.List;

import pms.domain.Mating;

public interface MatingService {
	
	List<Mating> getMatingList(int pageNo);
	List<Mating> getMatingLast();
  
	Mating getMatingOne(int matNo);
	
	Mating pages();
	
	Mating views(int matNo);
	
  void insert(Mating mating);
  
  int remove(int matNo);
  
  int change(Mating mating);
  
  void addviews(int matNo);
}







