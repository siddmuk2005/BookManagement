package com.myapp.spring.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myapp.spring.webmvc.handlerexceptionresolver.MyException;
import com.myapp.spring.webmvc.model.LoginModel;
//handler class
public class LoginController implements Controller {
	private LoginModel loginModel;
	

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String type = this.loginModel.validate(uname, pass);
		if(type==null){
			throw new MyException("User Details are not valid");
			//return new ModelAndView("/Login.html");
		}else if(type.equalsIgnoreCase("admin")){
			return new ModelAndView("AdminHome");
		}
		else {
			return new ModelAndView("UserHome");
		}
		
	}

}
