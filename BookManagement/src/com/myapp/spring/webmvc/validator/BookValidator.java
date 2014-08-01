package com.myapp.spring.webmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myapp.spring.webmvc.bean.BookDetails;

public class BookValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(BookDetails.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BookDetails bookDetails=(BookDetails)target;
		//Rejects the given field if empty or white space
		ValidationUtils.rejectIfEmpty(errors, "bookName", "field.required","The book Name Field can't be empty ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edition", "field.required","The edition Field can't be empty or have white space ");
		ValidationUtils.rejectIfEmpty(errors, "author", "field.required","The author Field can't be empty");
		
		if(bookDetails.getIsbnNumber()!=null&&!bookDetails.getIsbnNumber().equals("")&&bookDetails.getIsbnNumber().length()<5){
			errors.rejectValue("isbnNumber", "field.minlength",new Object[]{Integer.valueOf(5)},"The ISBN Number must contain five character");
		}
	}

}
