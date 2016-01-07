package pms.dao;

import pms.domain.Pet;

public interface PetDao {
  Pet petSelectOne(int pno);
  
  void insert(Pet pet);
  
  int delete(int pno);
  
  int update(Pet pet);
}







