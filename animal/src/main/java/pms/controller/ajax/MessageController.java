package pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pms.domain.AjaxResult;
import pms.domain.Member;
import pms.domain.Message;
import pms.service.MemberService;
import pms.service.MessageService;

@Controller("ajax.MessageController")
@RequestMapping("/message/ajax/*")
public class MessageController { 
	
	@Autowired MessageService messageService;
	@Autowired MemberService memberService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list(int recvMno,
			@RequestParam(defaultValue="1") int pageNo) throws Exception {
		 
		List<Message> message = messageService.msgList(recvMno, pageNo);
		
		Member member = null;
		List<Member> memberMap = new ArrayList<>();
		
		for (Message m : message) {
			member = memberService.oneMember(m.getSendMno());
			memberMap.add(member);
		}
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("message", message);
		resultMap.put("memberMap", memberMap);
		
		return resultMap;
		
	}
	
	@RequestMapping("send")
	public Object send(Message message, String mEmail) throws Exception {
		
		Member member = memberService.findNum(mEmail);
		message.setRecvMno(member.getMno());
		
		messageService.add(message);
		
		return new AjaxResult("success", null);
		
	}
	
	@RequestMapping("check")
	public Object check(String mEmail) throws Exception {
		
		if (memberService.findNum(mEmail) == null) {
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
		
	}
	
	@RequestMapping("detail")
	public Object detail(int msgNo) throws Exception {
		
		Message message = messageService.msgDetail(msgNo);
		
		messageService.readMsg(msgNo);
		
		return new AjaxResult("success", message);
		
	}
}
