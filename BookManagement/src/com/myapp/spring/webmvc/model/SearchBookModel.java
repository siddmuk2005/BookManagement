package com.myapp.spring.webmvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.myapp.spring.webmvc.bean.BookDetails;


public class SearchBookModel {
	private JdbcTemplate jdbcTemplate;
	private BookRowMapper bookRowMapper;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setBookRowMapper(BookRowMapper bookRowMapper){
		this.bookRowMapper=bookRowMapper;
	}

	public BookDetails getBookDetailsByISBNNumber(int bookNumber){
		String query="select * from testspringjdbc.bookdetails where booknumber=?";
		return (BookDetails)jdbcTemplate.query(query, new Object[]{new Integer(bookNumber)},new ResultSetExtractor<Object>() {

			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if(rs.next()){
					BookDetails bookDetails=new BookDetails();
					bookDetails.setId(rs.getInt("id"));
					bookDetails.setBookName(rs.getString("name"));
					bookDetails.setIsbnNumber(rs.getString("isbnNumber"));
					bookDetails.setAuthor(rs.getString("author"));
					bookDetails.setEdition(rs.getString("edition"));
							
					return bookDetails;
				}
				return null;
			}
		});
	}
	
	public List<BookDetails> getBookDetailsByBookGroupNumber(int bookGroupNumber){
		
		return new ArrayList<BookDetails>();
	}

}
