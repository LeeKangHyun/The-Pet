package pms.dao;

import java.util.List;

import pms.domain.Mating;

public interface MatingDao {
	List<Mating> matingList(int pageNo);
  
	Mating selectOne(int matNo);
	
	Mating count();
	
	void views();
	
  void insert(Mating mating);
  
  void updateviews(int matNo);
  
  int delete(int matNo);
  
  int update(Mating mating);
}







