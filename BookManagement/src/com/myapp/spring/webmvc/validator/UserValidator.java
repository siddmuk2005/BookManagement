package com.myapp.spring.webmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myapp.spring.webmvc.bean.UserDetails;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(UserDetails.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDetails userDetails=(UserDetails)target;
		//Rejects the given field if empty or white space
		ValidationUtils.rejectIfEmpty(errors, "userName", "field.required","The User Name Field can't be empty ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "field.required","The User Password Field can't be empty or white space");
		
		if(userDetails.getUserPassword()!=null&&!userDetails.getUserPassword().equals("")&&userDetails.getUserPassword().length()<5){
			errors.rejectValue("userPassword", "field.minlength",new Object[]{Integer.valueOf(5)},"The Password must contain five character");
		}
	}

}
