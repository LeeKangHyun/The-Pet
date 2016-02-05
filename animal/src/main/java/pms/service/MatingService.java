package pms.service;

import java.util.HashMap;
import java.util.List;

import pms.domain.Files;
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
  
  double filterCount(HashMap<String,Object> paramMap);
  
  List<Mating> filter_list(HashMap<String,Object> paramMap);
  
  Files getsize(String filename);
  
}







