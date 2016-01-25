package pms.domain;

import java.io.Serializable;

public class Walk implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String lat;
  protected String lng;
  protected int lno;
  protected int mno;
  
  public Walk () {}

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public int getLno() {
    return lno;
  }

  public void setLno(int lno) {
    this.lno = lno;
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }
  
  
  
}
