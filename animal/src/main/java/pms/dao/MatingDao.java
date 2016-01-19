package pms.dao;

import java.util.List;

import pms.domain.Mating;

public interface MatingDao {
	List<Mating> matingList();
  
  void insert(Mating mating);
  
  int delete(int matNo);
  
  int update(Mating mating);
}







