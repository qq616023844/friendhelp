package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import serviceimpl.ServiceRecommendImpl;

@Controller
@RequestMapping("/recommend")
public class ConRecommendation {
	
	@Resource
	private ServiceRecommendImpl serviceRecommendImpl;
	
	@RequestMapping(value = "/getRecommendation",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
	@ResponseBody
	public String getRecommendation(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.getReader().readLine()
		//request.getParameter("content")
		return serviceRecommendImpl.getRecommend(request.getParameter("content"));
	}
	
}
