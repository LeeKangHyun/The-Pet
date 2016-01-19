package pms.domain;

import java.io.Serializable;

public class Lot implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String lat;
  protected String lng;
  
  public Lot () {}

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

  
}
