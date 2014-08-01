package com.myapp.spring.webmvc.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import com.myapp.spring.webmvc.bean.BookDetails;

public class AddBookModel {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean addBookDetails(final BookDetails bookDetails){
		int status;
		String sql="insert into testspringjdbc.bookdetails values(?, ?, ?, ?,?)";
		try{
		PreparedStatementSetter setter=new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, bookDetails.getId());
				preparedStatement.setString(2, bookDetails.getBookName());
				preparedStatement.setString(3, bookDetails.getIsbnNumber());
				preparedStatement.setString(4, bookDetails.getAuthor());
				preparedStatement.setString(5, bookDetails.getEdition());
			}
		};
		status = this.jdbcTemplate.update(sql, setter);
		if(status==1)
			return true;
		else{
			return false;
		}
		
		}catch(DataAccessException ex){
			return false;
		}

	}

}
