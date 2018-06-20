package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import serviceimpl.ServiceVideoImpl;

@Controller
@RequestMapping("/upload")
public class ConVideoUpload {

	
	@Resource
	private ServiceVideoImpl serviceVideoImpl;
	
	
	@RequestMapping(value = "/fileupload",method = RequestMethod.POST)
	@ResponseBody
	public String fileupload(@RequestParam CommonsMultipartFile file,HttpServletRequest request) throws IOException{
		String realUploadPath = request.getSession().getServletContext().getRealPath("/");
		
		String uurl = "video/"+UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		String fileURL = "D:/apache-tomcat-8.5.28/webapps/"+uurl;
		File uploadfile = new File(fileURL);
		
        InputStream inputStream=file.getInputStream();   
        OutputStream outputStream=new FileOutputStream(uploadfile);       

        byte[] buffer=new byte[1024];  
        while((inputStream.read(buffer))>0)  
        {  
          outputStream.write(buffer);  
        }  
        outputStream.close();
        
        String title = request.getParameter("title");
        String group = request.getParameter("group");
        
        serviceVideoImpl.sendVideo(uurl, title, group);
        
		return null;  
	}
}
