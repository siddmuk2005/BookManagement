package com.myapp.spring.webmvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.myapp.spring.webmvc.bean.BookDetails;


public class BookRowMapper implements RowMapper<Object>{

	@Override
	public Object mapRow(ResultSet rs, int rowcount) throws SQLException {
		BookDetails bookDetails=new BookDetails();
		bookDetails.setId(rs.getInt("id"));
		bookDetails.setBookName(rs.getString("name"));
		bookDetails.setIsbnNumber(rs.getString("isbnNumber"));
		bookDetails.setAuthor(rs.getString("author"));
		bookDetails.setEdition(rs.getString("edition"));
		return bookDetails;
	}

}
