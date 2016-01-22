package pms.dao;

import java.util.List;

import pms.domain.Mating;

public interface MatingDao {
	List<Mating> matingList();
  
	Mating selectOne(int matNo);
	
  void insert(Mating mating);
  
  void updateviews(int matNo);
  
  int delete(int matNo);
  
  int update(Mating mating);
}






