package pms.service;

import java.util.List;

import pms.domain.Walk;

public interface WalkService {
  int add(Walk walk);
  
  List<Walk> list(int mno);
}
