package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceimpl.ServiceCommentImpl;
import serviceimpl.ServiceProblemImpl;

@Controller
@RequestMapping("/problem")
public class ConProblem {
	
	@Autowired
	private ServiceProblemImpl serviceProblemImpl;
	
/*	@RequestMapping(value = "/sendProblem",method = RequestMethod.POST)
	@ResponseBody
	public String sendProblem(HttpServletRequest request, HttpServletResponse response){
		
		return serviceProblemImpl.sendProblem(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/getDetailProblem",method = RequestMethod.POST)
	@ResponseBody
	public String getDetailProblem(HttpServletRequest request, HttpServletResponse response){
		
		return serviceProblemImpl.getDetailProblem(request.getParameter("content"));
	}*/
	
	@RequestMapping(value = "/sendProblem",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String sendProblem(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		return serviceProblemImpl.sendProblem(request.getParameter("content"));
	}
	
	@RequestMapping(value = "/getDetailProblem",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getDetailProblem(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		return serviceProblemImpl.getDetailProblem(request.getParameter("content"));
	}
}
