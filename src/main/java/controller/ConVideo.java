package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceimpl.ServiceProblemImpl;
import serviceimpl.ServiceVideoImpl;

@Controller
@RequestMapping("/video")
public class ConVideo {

	@Autowired
	private ServiceVideoImpl serviceVideoImpl;
	
/*	@RequestMapping(value = "/sendVideo",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String sendVideo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getParameter("content")
		return serviceVideoImpl.sendVideo(request.getReader().readLine());
	}*/
	
	@RequestMapping(value = "/getDetailVideo",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getDetailVideo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		return serviceVideoImpl.getDetailVideo(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/getDanmaku",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getDanmaku(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getParameter("content")
		return serviceVideoImpl.getDanmaku(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/sendDanmaku",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String sendDanmaku(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getParameter("content")
		//request.getReader().readLine()
		return serviceVideoImpl.sendDanmaku(request.getParameter("content"));
	}
}
