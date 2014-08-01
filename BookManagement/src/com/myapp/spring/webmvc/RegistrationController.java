package com.myapp.spring.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.myapp.spring.webmvc.bean.UserDetails;
import com.myapp.spring.webmvc.model.AddUserModel;

public class RegistrationController extends AbstractWizardFormController{
	AddUserModel addUserModel;

	public void setAddEmployeeModel(AddUserModel addUserModel) {
		this.addUserModel = addUserModel;
	}
	@Override
	protected void validatePage(Object command, Errors errors, int page,
			boolean finish) {
		UserDetails userDetails =(UserDetails)command;
		if(page==1){
			if(!userDetails.getUserPassword().equalsIgnoreCase(userDetails.getRePassword())){
				errors.rejectValue("userPassword", "field.pass",new Object[]{},"Password and re password must be same");
			}
		}
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException exception)
			throws Exception {
		UserDetails userDetails=(UserDetails)command;
		boolean flag = addUserModel.addUser(userDetails);
		if(flag){
			return new ModelAndView("RegistrationSuccess");
		}
		return new ModelAndView("RegistrationFail.html");
	}

}
