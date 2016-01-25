package pms.dao;

import java.util.List;

import pms.domain.Walk;

public interface WalkDao {
  int add(Walk lot);
  
  List<Walk> list(int mno);
}
