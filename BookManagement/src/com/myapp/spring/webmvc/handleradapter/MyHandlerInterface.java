package com.myapp.spring.webmvc.handleradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerInterface {
	public String process(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
