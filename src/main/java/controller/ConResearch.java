package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceimpl.ServiceCommentImpl;
import serviceimpl.ServiceSearchImpl;

@Controller
@RequestMapping("/research")
public class ConResearch {

	@Resource
	private ServiceSearchImpl servicesearchImpl;
	
	@RequestMapping(value = "/getAllType",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getAllType(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getReader().readLine()
		return servicesearchImpl.getAllType(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/getByNeed",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getByNeed(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getParameter("content")
		return servicesearchImpl.getByNeed(request.getParameter("content"));
	}
}
