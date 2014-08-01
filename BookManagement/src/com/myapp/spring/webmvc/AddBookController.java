package com.myapp.spring.webmvc;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.myapp.spring.webmvc.bean.BookDetails;
import com.myapp.spring.webmvc.model.AddBookModel;

public class AddBookController extends SimpleFormController{
	AddBookModel addBookModel;

	public void setAddBookModel(AddBookModel addBookModel) {
		this.addBookModel = addBookModel;
	}
	
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		BookDetails bookDetails=(BookDetails)command;
		addBookModel.addBookDetails(bookDetails);
	}
}
