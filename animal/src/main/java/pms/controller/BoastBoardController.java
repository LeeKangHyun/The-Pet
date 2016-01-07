package pms.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pms.domain.Diary;
import pms.service.BoastBoardService;

@Controller
@RequestMapping("/BoastBoard/*")
public class BoastBoardController { 
	//public static final String SAVED_DIR = "/attachfile";
	
	@Autowired BoastBoardService boastboardService;
	@Autowired ServletContext servletContext;

	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="no") String keyword,
			@RequestParam(defaultValue="desc") String align,
			Model model) throws Exception {

		List<Diary> boastboards = boastboardService.selectList(pageNo, pageSize, keyword, align);
		model.addAttribute("boastboards", boastboards);

		return "BoastBoard/boastBoard";
	}
	
}
