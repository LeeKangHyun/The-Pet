package pms.dao;

import java.util.List;

import pms.domain.Walk;

public interface WalkDao {
  int add(Walk walk);
  
  List<Walk> list(int sno);
}
