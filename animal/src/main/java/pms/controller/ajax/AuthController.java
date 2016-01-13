package pms.controller.ajax;

import javax.servlet.ServletContext;

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
  
  @RequestMapping(value="login", method=RequestMethod.POST)
  public AjaxResult login(
      String mEmail,
      String password) {
 
    Member member = memberService.login(mEmail, password);
    return new AjaxResult("success", member);
  }
}

