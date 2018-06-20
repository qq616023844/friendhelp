package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;

import entity.Reason;
import serviceimpl.ServiceCommentImpl;

@Controller
@RequestMapping("/comment")
public class ConComment {
	
	//@Autowired
	@Resource
	private ServiceCommentImpl serviceCommentImpl;
	
	@RequestMapping(value = "/sendComment",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String sendComment(HttpServletRequest request, HttpServletResponse response) throws IOException{

		System.out.println("get");
	//	response.getWriter().write("11111111111111");
		//"{\"result\":true,\"reason\":null}"
		//new GsonBuilder().serializeNulls().create().toJson(reason)
		//request.getParameter("content")
		String s = serviceCommentImpl.sendComment(request.getParameter("content"));
		return s;

	}
	
	@RequestMapping(value = "/getComment",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getDetailComment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getParameter("content")
		//request.getReader().readLine()
		return serviceCommentImpl.getComment(request.getParameter("content"));
	}
	
	
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public void test(HttpServletRequest request){
		System.out.println("get it:date = "+new Date());
		System.out.println(request.getSession().getServletContext().getRealPath("")+"pictures\\"+"1.png");
	}
	
}
