package com.myapp.spring.webmvc.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.myapp.spring.webmvc.bean.UserDetails;
import com.mysql.jdbc.Statement;

public class AddUserModel {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean addUser(final UserDetails userDetails){
		int status;
		String sql="insert into testspringjdbc.userdetails values(?,?, ?, ?, ?, ?, ?)";
		try{
		PreparedStatementSetter setter=new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				
				preparedStatement.setInt(1,    userDetails.getId());
				preparedStatement.setString(2, userDetails.getUserName());
				preparedStatement.setString(3, userDetails.getUserPassword());
				preparedStatement.setString(4, userDetails.getEmail());
				preparedStatement.setString(5, userDetails.getAddress());
				preparedStatement.setString(6, userDetails.getMobile());
				preparedStatement.setString(7, userDetails.getType());
				}
			
		};
		status = this.jdbcTemplate.update(sql, setter);
		if(status==1||status==Statement.SUCCESS_NO_INFO)
			return true;
		else{
			return false;
		}
		
		}catch(DataAccessException ex){
			return false;
		}
	}
}
