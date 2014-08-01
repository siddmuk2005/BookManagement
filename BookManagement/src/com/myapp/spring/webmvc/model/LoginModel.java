package com.myapp.spring.webmvc.model;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginModel {
	private JdbcTemplate jdbcTemplate;

	public LoginModel(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public String validate(String uname,String pass) {
		try{
		String ststus="";
		String sql="select type from testspringjdbc.userdetails where username=\'"+uname+"\' and userpass=\'"+pass+"\'";
		ststus = this.jdbcTemplate.queryForObject(sql, String.class);
		return ststus;
		}catch(EmptyResultDataAccessException ex){
			return null;
		}
	}
	
}
