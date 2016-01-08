package pms.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pms.domain.Diary;
import pms.service.BoastBoardService;
import pms.service.support.DefaultBoastBoardService;

@Controller
@RequestMapping("/BoastBoard/*")
public class BoastBoardController { 
  private static Logger log = Logger.getLogger(DefaultBoastBoardService.class);
  //public static final String SAVED_DIR = "/attachfile";

  @Autowired BoastBoardService boastboardService;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="list", method=RequestMethod.GET)
  public String list(Model model) throws Exception {
    List<Diary> boastboards = boastboardService.selectList();
    model.addAttribute("boastboards", boastboards);

    return "BoastBoard/boastBoard";
  }

}
