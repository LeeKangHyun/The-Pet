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
import pms.domain.Receive;
import pms.service.MemberService;
import pms.service.ReceiveService;

@Controller("ajax.MessageController")
@RequestMapping("/message/ajax/*")
public class MessageController { 
	
	@Autowired ReceiveService reciveService;
	@Autowired MemberService memberService;
	@Autowired ServletContext servletContext;

	@RequestMapping("recvList")
	public Object recvList(int recvMno,
			@RequestParam(defaultValue="1") int pageNo) throws Exception {
		 
		List<Receive> message = reciveService.msgList(recvMno, pageNo);
		
		Member member = null;
		List<Member> memberMap = new ArrayList<>();
		
		for (Receive m : message) {
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
	public Object send(Receive recvmsg, String mEmail) throws Exception {
		
		Member member = memberService.findNum(mEmail);
		recvmsg.setRecvMno(member.getMno());
		
		reciveService.add(recvmsg);

		return new AjaxResult("success", null);
		
	}
	
	@RequestMapping("check")
	public Object check(String mEmail) throws Exception {
		
		if (memberService.findNum(mEmail) == null) {
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
	}
	
	@RequestMapping("recvPage")
	public Object recvPage(int recvMno) throws Exception {

		Receive recv = reciveService.recvBoxCount(recvMno);
		System.out.println(recv.getCount());
		double page = Math.ceil(recv.getCount()/15);
		System.out.println(page);
		return new AjaxResult("success", page);
	}
	
	@RequestMapping("recvDetail")
	public Object detail(int msgNo) throws Exception {
		
		Receive message = reciveService.msgDetail(msgNo);
		
		reciveService.readMsg(msgNo);
		
		return new AjaxResult("success", message);
		
	}

	@RequestMapping("noReadMsg")
	public Object noReadMsg(int recvMno) throws Exception {
		
		Receive message = reciveService.noReadMsg(recvMno);
		
		return new AjaxResult("success", message);
		
	}
	
	@RequestMapping("delRecvMsg")
	public Object delRecvMsg(int msgNo) throws Exception {
		
		if(reciveService.remove(msgNo) <= 0) {
			return new AjaxResult("failure", null);
		}
		return new AjaxResult("success", null);
		
	}
	
	@RequestMapping("delRecvMsgAll")
	public Object delRecvMsgAll(int recvMno) throws Exception {
		
		if(reciveService.removeAll(recvMno) <= 0) {
			return new AjaxResult("failure", null);
		}
		return new AjaxResult("success", null);
		
	}
	
}
