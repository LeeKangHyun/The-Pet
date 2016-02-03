package pms.domain;

import java.io.Serializable;

public class Walk implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int lno;
  protected String locLat;
  protected String locLng;
  protected String locName;
  protected String locDong;  
  protected int dno;
  
  public Walk () {}

  public int getLno() {
    return lno;
  }

  public void setLno(int lno) {
    this.lno = lno;
  }

  public String getLocLat() {
    return locLat;
  }

  public void setLocLat(String locLat) {
    this.locLat = locLat;
  }

  public String getLocLng() {
    return locLng;
  }

  public void setLocLng(String locLng) {
    this.locLng = locLng;
  }

  public String getLocName() {
    return locName;
  }

  public void setLocName(String locName) {
    this.locName = locName;
  }

  public String getLocDong() {
    return locDong;
  }

  public void setLocDong(String locDong) {
    this.locDong = locDong;
  }

  public int getDno() {
    return dno;
  }

  public void setDno(int dno) {
    this.dno = dno;
  }

	
}
