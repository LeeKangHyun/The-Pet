package pms.dao;

import java.util.List;

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
}







