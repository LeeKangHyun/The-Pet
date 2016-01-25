package pms.service;

import java.util.List;

import pms.domain.Walk;

public interface WalkService {
  int add(Walk lot);
  
  List<Walk> list(int mno);
}
