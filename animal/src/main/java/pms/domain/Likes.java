package pms.domain;

import java.io.Serializable;

public class Likes implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int lno;
  protected int memno;
  protected int eduno;
  protected int matno;
  protected int sno;
  protected int dno;
  
  public Likes() {}
  
  public int getLno() {
    return lno;
  }
  public void setLno(int lno) {
    this.lno = lno;
  }
  public int getMemno() {
    return memno;
  }
  public void setMemno(int memno) {
    this.memno = memno;
  }
  public int getEduno() {
    return eduno;
  }
  public void setEduno(int eduno) {
    this.eduno = eduno;
  }
  public int getMatno() {
    return matno;
  }
  public void setMatno(int matno) {
    this.matno = matno;
  }
  public int getSno() {
    return sno;
  }
  public void setSno(int sno) {
    this.sno = sno;
  }
  public int getDno() {
    return dno;
  }
  public void setDno(int dno) {
    this.dno = dno;
  }
  
}
