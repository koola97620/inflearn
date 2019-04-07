package com.example.demowebmvc;

import java.io.File;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author choijaeyong on 07/04/2019.
 * @project demo-web-mvc
 * @description
 */

@Controller
public class FileController {

  @Autowired
  ResourceLoader resourceLoader;



  @GetMapping("/file")
  public String fileUploadForm(Model model) {



    return "files/index";
  }

  @PostMapping("/file")
  public String fileUpload(@RequestParam MultipartFile file , RedirectAttributes attributes) {
    // 스토리지에 save 하는 과정은 생략

    System.out.println(file.getName());
    String message = file.getOriginalFilename() + " is uploaded.";
    attributes.addFlashAttribute("message" , message);

    return "redirect:/file";
  }

  @GetMapping("/file/{filename}")
  public ResponseEntity<Resource>fileDownload(@PathVariable String filename) throws Exception {

    Resource resource = resourceLoader.getResource("classpath:" + filename);
    File file = resource.getFile();

    Tika tika = new Tika(); 
    String type = tika.detect(file);


    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION , "attachment: filename\""+resource.getFilename() + "\"")
            .header(HttpHeaders.CONTENT_TYPE, type)
            .header(HttpHeaders.CONTENT_LENGTH, file.length() + "")// 헤더는 문자여야 하기 때문에 + ""
            .body(resource);

  }






}
