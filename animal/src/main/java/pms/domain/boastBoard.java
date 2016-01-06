package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/*boastBoard(자랑하기게시판)*/
public class boastBoard  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String cateCode; /*카테고리 코드*/
  protected String cateName;/*카테고리 명*/
  protected int schNum;/*일정번호*/
  protected int petNum;/*펫번호*/
  protected Date startDate;/*시작일*/
  protected Date endDate;/*종료일*/
  protected Date schCre;/*작성일*/
  protected String schContent;/*내용*/
  protected String schTitle;/*제목*/
  protected int notiHide;/*공개여부*/
  protected int notiViews;/*조회수*/
  protected int notiLikes;/*좋아요*/

  public String getCateCode() {
    return cateCode;
  }
  public void setCateCode(String cateCode) {
    this.cateCode = cateCode;
  }
  public String getCateName() {
    return cateName;
  }
  public void setCateName(String cateName) {
    this.cateName = cateName;
  }
  public int getSchNum() {
    return schNum;
  }
  public void setSchNum(int schNum) {
    this.schNum = schNum;
  }
  public int getPetNum() {
    return petNum;
  }
  public void setPetNum(int petNum) {
    this.petNum = petNum;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Date getSchCre() {
    return schCre;
  }
  public void setSchCre(Date schCre) {
    this.schCre = schCre;
  }
  public String getSchContent() {
    return schContent;
  }
  public void setSchContent(String schContent) {
    this.schContent = schContent;
  }
  public String getSchTitle() {
    return schTitle;
  }
  public void setSchTitle(String schTitle) {
    this.schTitle = schTitle;
  }
  public int getNotiHide() {
    return notiHide;
  }
  public void setNotiHide(int notiHide) {
    this.notiHide = notiHide;
  }
  public int getNotiViews() {
    return notiViews;
  }
  public void setNotiViews(int notiViews) {
    this.notiViews = notiViews;
  }
  public int getNotiLikes() {
    return notiLikes;
  }
  public void setNotiLikes(int notiLikes) {
    this.notiLikes = notiLikes;
  }


}