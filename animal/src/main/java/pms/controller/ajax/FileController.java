package pms.controller.ajax;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("ajax.FileController")
@RequestMapping("/file/ajax/*")
public class FileController {

  @RequestMapping(value = "uploadMyFile", method = RequestMethod.POST)
  public String handleFileUpload(MultipartHttpServletRequest request)
      throws Exception {
    Iterator<String> itrator = request.getFileNames();
    MultipartFile multiFile = request.getFile(itrator.next());
    try {
      // just to show that we have actually received the file
      System.out.println("File Length:" + multiFile.getBytes().length);
      System.out.println("File Type:" + multiFile.getContentType());
      String fileName=multiFile.getOriginalFilename();
      System.out.println("File Name:" +fileName);
      String path=request.getServletContext().getRealPath("/");

      //making directories for our required path.
//      byte[] bytes = multiFile.getBytes();
//      File directory= new File(path+ "/uploads");
//      directory.mkdirs();

      // saving the file
//      File file=new File(directory.getAbsolutePath()+System.getProperty("file.separator")+picture.getName());
//      BufferedOutputStream stream = new BufferedOutputStream(
//          new FileOutputStream(file));
//      stream.write(bytes);
//      stream.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new Exception("Error while loading the file");
    }
    return toJson("File Uploaded successfully.");
  }

  public String toJson(Object data)
  {
    ObjectMapper mapper=new ObjectMapper();
    StringBuilder builder=new StringBuilder();
    try {
      builder.append(mapper.writeValueAsString(data));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return builder.toString();
  }
}

