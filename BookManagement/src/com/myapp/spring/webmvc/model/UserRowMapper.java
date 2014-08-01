package com.myapp.spring.webmvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myapp.spring.webmvc.bean.UserDetails;

public class UserRowMapper implements RowMapper<Object>{

	@Override
	public Object mapRow(ResultSet rs, int rowcount) throws SQLException {
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

}
