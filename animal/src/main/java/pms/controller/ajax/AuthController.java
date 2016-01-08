package pms.controller.ajax;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pms.domain.AjaxResult;
import pms.domain.Member;
import pms.service.MemberService;

@Controller("ajax.MemberController")
@RequestMapping("/auth/ajax/*")
public class AuthController { 
	
  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="login", method=RequestMethod.GET)
  public String loginform() {
  	return "login.html";
  }
  
  @RequestMapping(value="login", method=RequestMethod.POST)
  public AjaxResult login(
      String mEmail,
      String password,
      String saveEmail,
      HttpServletResponse response,
      HttpSession session) {

    Cookie emailCookie = null;
    if (saveEmail != null) { // 이메일 저장을 체크했으면,
      emailCookie = new Cookie("mEmail", mEmail);
      emailCookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      emailCookie = new Cookie("mEmail", "");
      emailCookie.setMaxAge(0); // 웹브라우저에게 email 쿠키 삭제를 명령한다.
    }
    response.addCookie(emailCookie);
    
    Member member = memberService.login(mEmail, password);

    if (member == null) { // 로그인 실패!
      session.invalidate(); // 세션을 무효화시킴. => 새로 세션 객체 생성!
      return new AjaxResult("failure", null);
    }

    session.setAttribute("loginUser", member);
    
    return new AjaxResult("success", null);
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session) {
    
    session.invalidate();
    return "redirect:../../login.html";
  }
}

