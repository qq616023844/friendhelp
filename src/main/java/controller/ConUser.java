package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceimpl.ServiceUserImpl;

@Controller
@RequestMapping("/userController")
public class ConUser {

	@Resource
	private ServiceUserImpl serviceUserImpl;
	
	@RequestMapping(value = "/myQuestion",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String myQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getReader().readLine()
		return serviceUserImpl.myQuestion(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getReader().readLine()
		return serviceUserImpl.login(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/loginByQQ",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String loginByQQ(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getReader().readLine()
		return serviceUserImpl.loginByQQ(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String register(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getReader().readLine()
		return serviceUserImpl.register(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/registerCheck",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String registerCheck(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return serviceUserImpl.registerCheck(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/registerCheckend",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String registerCheckend(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return serviceUserImpl.registerCheckend(request.getParameter("content"));
	}
	
	
	@RequestMapping(value = "/registerCheckendByQQ",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String registerCheckendByQQ(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return serviceUserImpl.registerCheckendByQQ(request.getParameter("content"));
	}
}
