package pms.domain;

import java.io.Serializable;

public class boastBoard  implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String cate_code;
  protected String cate_name;
  protected String sch_num;
  protected String pet_num;
  protected String start_date;
  protected String end_date;
  protected String sch_cre;
  protected String sch_content;
  protected String sch_title;
  protected String noti_open;
  protected String noti_views;
  protected String noti_likes;
  
  public String getCate_code() {
    return cate_code;
  }
  public void setCate_code(String cate_code) {
    this.cate_code = cate_code;
  }
  public String getCate_name() {
    return cate_name;
  }
  public void setCate_name(String cate_name) {
    this.cate_name = cate_name;
  }
  public String getSch_num() {
    return sch_num;
  }
  public void setSch_num(String sch_num) {
    this.sch_num = sch_num;
  }
  public String getPet_num() {
    return pet_num;
  }
  public void setPet_num(String pet_num) {
    this.pet_num = pet_num;
  }
  public String getStart_date() {
    return start_date;
  }
  public void setStart_date(String start_date) {
    this.start_date = start_date;
  }
  public String getEnd_date() {
    return end_date;
  }
  public void setEnd_date(String end_date) {
    this.end_date = end_date;
  }
  public String getSch_cre() {
    return sch_cre;
  }
  public void setSch_cre(String sch_cre) {
    this.sch_cre = sch_cre;
  }
  public String getSch_content() {
    return sch_content;
  }
  public void setSch_content(String sch_content) {
    this.sch_content = sch_content;
  }
  public String getSch_title() {
    return sch_title;
  }
  public void setSch_title(String sch_title) {
    this.sch_title = sch_title;
  }
  public String getNoti_open() {
    return noti_open;
  }
  public void setNoti_open(String noti_open) {
    this.noti_open = noti_open;
  }
  public String getNoti_views() {
    return noti_views;
  }
  public void setNoti_views(String noti_views) {
    this.noti_views = noti_views;
  }
  public String getNoti_likes() {
    return noti_likes;
  }
  public void setNoti_likes(String noti_likes) {
    this.noti_likes = noti_likes;
  }
  
  @Override
  public String toString() {
    return "boastBoard [cate_code=" + cate_code + ", cate_name=" + cate_name + ", sch_num=" + sch_num + ", pet_num="
        + pet_num + ", start_date=" + start_date + ", end_date=" + end_date + ", sch_cre=" + sch_cre + ", sch_content="
        + sch_content + ", sch_title=" + sch_title + ", noti_open=" + noti_open + ", noti_views=" + noti_views
        + ", noti_likes=" + noti_likes + "]";
  }
  
  
  
}
