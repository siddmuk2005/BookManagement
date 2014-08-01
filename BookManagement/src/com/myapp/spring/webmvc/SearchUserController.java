package com.myapp.spring.webmvc;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myapp.spring.webmvc.bean.UserDetails;
import com.myapp.spring.webmvc.model.SearchUserModel;

public class SearchUserController extends MultiActionController{
	
	SearchUserModel searchEmployeeModel;

	public void setSearchEmployeeModel(SearchUserModel searchEmployeeModel) {
		this.searchEmployeeModel = searchEmployeeModel;
	}
	public ModelAndView searchByEmployeeNumber(HttpServletRequest request,HttpServletResponse response){
		int employeeNumber = Integer.parseInt(request.getParameter("searchKey"));
		UserDetails employeeDetails = searchEmployeeModel.getEmployeeDetailsByEmployeeNumber(employeeNumber);
		
		return new ModelAndView("successSingleEmployeeDetails","employeeDetails",employeeDetails);
	}
	public ModelAndView searchByEmployeeName(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView();
	}

	public ModelAndView searchByEmployeeType(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView();
	}
	public ModelAndView searchByDepartmentNumber(HttpServletRequest request,HttpServletResponse response){
		int departmentNumber = Integer.parseInt(request.getParameter("searchKey"));
		Collection<UserDetails> employeeDetails = searchEmployeeModel.getUserDetailsByUserId(departmentNumber);
		return new ModelAndView("successMultipleEmployeeDetails","employeeDetails",employeeDetails);
	}


}
