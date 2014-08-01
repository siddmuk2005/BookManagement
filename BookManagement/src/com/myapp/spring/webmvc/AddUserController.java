package com.myapp.spring.webmvc;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.myapp.spring.webmvc.bean.UserDetails;
import com.myapp.spring.webmvc.model.AddUserModel;
import com.myapp.spring.webmvc.model.LoginModel;

public class AddUserController extends AbstractCommandController{
	AddUserModel addUserModel;

	public void setAddEmployeeModel(AddUserModel addUserModel) {
		this.addUserModel = addUserModel;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException exception)
			throws Exception {
		
		if(exception.hasErrors()){
			PrintWriter writer  = response.getWriter();

			writer.println("Eroor in validating User details</br>");
						writer.println("we have found some errors in the data submitted by you.</br> Total number of errors:"+exception.getErrorCount());
			List<FieldError> fieldErrors = exception.getFieldErrors();
			for (Iterator iterator = fieldErrors.iterator(); iterator.hasNext();) {
				FieldError fieldError = (FieldError) iterator.next();
				writer.println(fieldError.getDefaultMessage()+"</br>");
				
			}
			
			FieldError userPasswordFieldError = exception.getFieldError("userPassword");
			writer.println(userPasswordFieldError.getDefaultMessage());
			return null;
		}
		boolean status = this.addUserModel.addUser((UserDetails)command);
		if(status){
			return new ModelAndView("/AddEmployeeSuccess.html");
		}else{
			return new ModelAndView("/Error.html");
		}
		
	}

}
