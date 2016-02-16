package com.javalec.mybatis_ex.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.mybatis_ex.dto.ContentDto;

public class ContentDao implements IDao{

	private JdbcTemplate template;
	private String sql = null;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/*
	 * Default Constructor
	 */
	public ContentDao() {	}

	@Override
	public ArrayList<ContentDto> listDao() {
		// TODO Auto-generated method stub
		sql = "SELECT * "
			+ " FROM board "
			+ " order by mId desc";
		
		return (ArrayList<ContentDto>) template.query(sql, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}

	@Override
	public void writeDao(final String mWriter,final String mContent) {
		// TODO Auto-generated method stub
		System.out.println("writeDao()");
		
		sql = "INSERT INTO board(mId, mWriter, mContent) "
				+ " values(board_seq.nextval, ?, ?)";
		
		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, mWriter);
				pstmt.setString(2, mContent);
			}});
	}

	@Override
	public ContentDto viewDao(String strID) {
		// TODO Auto-generated method stub
		System.out.println("viewDao()");
		
		sql = "SELECT * "
			+ " FROM board "
			+ " WHERE mId = " + strID;
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}

	@Override
	public void deleteDao(final String bId) {
		// TODO Auto-generated method stub
		System.out.println("deleteDao()");
		
		sql = "DELETE FROM board "
				+ " WHERE mId = ?";
		
		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, Integer.parseInt(bId));
			}
		});
	}
	
	
	
}//End Class
