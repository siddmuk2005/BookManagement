package com.myapp.spring.webmvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.myapp.spring.webmvc.bean.UserDetails;

public class SearchUserModel {
	private JdbcTemplate jdbcTemplate;
	private UserRowMapper userRowMapper;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setUserRowMapper(UserRowMapper userRowMapper){
		this.userRowMapper=userRowMapper;
	}

	public UserDetails getEmployeeDetailsByEmployeeNumber(int userNumber){
		String query="select * from testspringjdbc.userdetails where id=?";
		return (UserDetails)jdbcTemplate.query(query, new Object[]{new Integer(userNumber)},new ResultSetExtractor<Object>() {

			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(rs.next()){
					UserDetails userDetails=new UserDetails();
					userDetails.setId(rs.getInt("id"));
					userDetails.setUserName(rs.getString("username"));
					userDetails.setUserPassword(rs.getString("userpass"));
					userDetails.setEmail(rs.getString("email"));//and so on
					userDetails.setAddress(rs.getString("address"));
					userDetails.setMobile(rs.getString("mobile"));
					userDetails.setType(rs.getString("type"));
					return userDetails;
				}
				return null;
			}
		});
	}
	
	public List<UserDetails> getUserDetailsByUserId(int userId){
		
		return new ArrayList<UserDetails>();
	}

}
