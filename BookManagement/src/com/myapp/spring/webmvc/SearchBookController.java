package com.myapp.spring.webmvc;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myapp.spring.webmvc.bean.BookDetails;
import com.myapp.spring.webmvc.bean.UserDetails;
import com.myapp.spring.webmvc.model.SearchBookModel;
import com.myapp.spring.webmvc.model.SearchUserModel;

public class SearchBookController extends MultiActionController{
	
	SearchBookModel searchBookModel;

	public void setSearchBookModel(SearchBookModel searchBookModel) {
		this.searchBookModel = searchBookModel;
	}
	public ModelAndView searchByBookNumber(HttpServletRequest request,HttpServletResponse response){
		int bookNumber = Integer.parseInt(request.getParameter("searchKey"));
		BookDetails bookDetails = searchBookModel.getBookDetailsByISBNNumber(bookNumber);
		
		return new ModelAndView("successSingleBookDetails","bookDetails",bookDetails);
	}
	public ModelAndView searchByBookName(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView();
	}

	public ModelAndView searchByBookType(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView();
	}
	public ModelAndView searchByBookISBNNumber(HttpServletRequest request,HttpServletResponse response){
		int isbnNumber = Integer.parseInt(request.getParameter("searchKey"));
		Collection<BookDetails> bookDetails = searchBookModel.getBookDetailsByBookGroupNumber(isbnNumber);
		return new ModelAndView("successMultipleBookDetails","bookDetails",bookDetails);
	}


}
