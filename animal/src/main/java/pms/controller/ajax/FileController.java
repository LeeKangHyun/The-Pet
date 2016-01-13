package pms.controller.ajax;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import pms.domain.AjaxResult;
import pms.domain.Files;
import pms.service.FilesService;
import pms.util.MultipartHelper;

@Controller("ajax.FileController")
@RequestMapping("/file/ajax/*")
public class FileController {

  @Autowired FilesService fileService;
  @Autowired ServletContext servletContext;

  @RequestMapping(value = "upload", method = RequestMethod.POST)
  public AjaxResult insert(Files files, MultipartFile file) throws Exception {
//    System.out.println("파일 크기: " + file.getBytes().length);
//    System.out.println("파일 타입: " + file.getContentType());
    String fileName = MultipartHelper.generateFilename(file.getOriginalFilename());
//    System.out.println("파일 이름: " + fileName);

    File attachFile = new File(servletContext.getRealPath("/files") 
        + "/" + fileName);

    file.transferTo(attachFile);
    files.setfName(fileName);

    fileService.fadd(files);

    return new AjaxResult("status" , null);
  }
}
