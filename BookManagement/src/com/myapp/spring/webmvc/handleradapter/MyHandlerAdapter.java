package com.myapp.spring.webmvc.handleradapter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerAdapter implements HandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		
		return(handler instanceof MyHandlerInterface);
		
	}

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		MyHandlerInterface myHandler=(MyHandlerInterface)handler;
		String view  = myHandler.process(request, response);
		Map model=(Map)request.getAttribute("model");
		if(view==null){
			return null;
		}else if(model==null){
			return new ModelAndView(view);
		}
		else {
			return new ModelAndView(view,model);
		}
		
	}

	@Override
	public long getLastModified(HttpServletRequest arg0, Object arg1) {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}



}
