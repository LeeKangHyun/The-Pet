package pms.dao;

import java.util.HashMap;
import java.util.List;

import pms.domain.Files;
import pms.domain.Mating;

public interface MatingDao {
	List<Mating> matingList(int pageNo);
	List<Mating> matingLast();
  
	Mating selectOne(int matNo);
	
	Mating count();
	
	Mating views(int matNo);
	
  void insert(Mating mating);
  
  void updateviews(int matNo);
  
  int delete(int matNo);
  
  int update(Mating mating);
  
  double filterCount(HashMap<String,Object> paramMap);
  
  List<Mating> filter_list(HashMap<String,Object> paramMap);
  
  Files getsize(String filename);
  
}







