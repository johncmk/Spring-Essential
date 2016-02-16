package com.javalec.spring_pjt_board.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.spring_pjt_board.dto.BDto;
import com.javalec.spring_pjt_board.util.Constant;


/**
 * Board Data Access Object
 * @author chaos408
 *
 */
public class BDao {

	
	private Connection conn = null;
	private String sql = null;
	private PreparedStatement pstmt = null;

	//Use JdbeTemplate instead of using Context
	private JdbcTemplate template = null;

	/**
	 * Constructor
	 */
	public BDao() {
		if(this.template == null) {
			this.template = Constant.template;
		}
	}
	
	/**
	 * Return list
	 * @return
	 */
	public ArrayList<BDto> list() {
		
		sql = "SELECT bid,"
				+ " bname,"
				+ " btitle,"
				+ " bdate,"
				+ " bhit,"
				+ " bgroup,"
				+ " bstep,"
				+ " bindent,"
				+ " bcontent "
			+ " FROM spring_mvc_board "
				+ " ORDER BY bgroup DESC,"
				+ " bstep ASC";
		
		return (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
	}//End
	
	/**
	 * Write Content
	 * @param bName
	 * @param bTitle
	 * @param bContent
	 */
	public void write(final String bName, final String bTitle, final String bContent) {
	
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				// TODO Auto-generated method stub
//	
//				sql = "INSERT INTO spring_mvc_board "
//						+ " (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent)"
//						+ " VALUES"
//						+ " (spring_mvc_board_seq.nextval, ? , ? , ?, 0 , spring_mvc_board_seq.currval, 0, 0)";
//				
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, bName);
//				pstmt.setString(2, bTitle);
//				pstmt.setString(3, bContent);
//				
//				return pstmt;
//			}
//		});
		
		sql = "INSERT INTO spring_mvc_board "
				+ " (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent)"
				+ " VALUES"
				+ " (spring_mvc_board_seq.nextval, ? , ? , ?, 0 , spring_mvc_board_seq.currval, 0, 0)";
		
		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
//				return pstmt;
			}});
		
	}//End
	
	/**
	 * Content View
	 * @param strID
	 * @return
	 */
	public BDto contentView(final String strID) {
		System.out.println("contentView()");
		
		upHit(strID);//Increment the view count
		
		sql = "SELECT * "
				+ " FROM spring_mvc_board "
				+ " WHERE bid = " + strID;

		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
	}//End

	/**
	 * increase number of the hit 
	 * on each time use click on the page
	 * @param bid
	 */
	private void upHit(final String bid){
		System.out.println("upHit");
		
		sql = "UPDATE spring_mvc_board "
				+ " SET bhit = bhit + 1 "
				+ " WHERE bid = ? ";
		
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, Integer.parseInt(bid));
			}
		});
	}//End
	
	/**
	 * Modify
	 * @param bid
	 * @param bname
	 * @param btitle
	 * @param bcontent
	 */
	public void modify(final String bid, final String bname, final String btitle, final String bcontent) {

		sql = "UPDATE spring_mvc_board "
				+ " SET bname = ?, "
				+ " btitle = ?, "
				+ " bcontent = ? "
				+ " WHERE bid = ? ";

		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				pstmt.setInt(4, Integer.parseInt(bid));
			}
			
		});
	}//End
	
	/**
	 * Delete Content
	 * @param bid
	 */
	public void delete(final String bid) {

		sql = "DELETE FROM spring_mvc_board "
				+ " WHERE bid = ? ";
		
		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, Integer.parseInt(bid));
			}
		});
	}//End
	
	/**
	 * Reply View
	 * @param strId
	 * @return
	 */
	public BDto reply_view( final String strId) {
		
		sql = "SELECT * "
				+ " FROM spring_mvc_board "
				+ " WHERE bid = " + strId;

		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
	}//End

	/**
	 * Reply
	 * @param bid
	 * @param bname
	 * @param btitle
	 * @param bcontent
	 * @param bgroup
	 * @param bstep
	 * @param bindent
	 */
	public void reply(final String bid, final String bname, final String btitle, final String bcontent, final String bgroup, final String bstep, final String bindent) {
		
		replyShape(bgroup, bstep);
		
		sql = "INSERT INTO spring_mvc_board (bid, bname, btitle, bcontent, bgroup, bstep, bindent) "
				+ " VALUES(spring_mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				pstmt.setInt(4, Integer.parseInt(bgroup));
				pstmt.setInt(5, Integer.parseInt(bstep)+ 1);
				pstmt.setInt(6, Integer.parseInt(bindent) + 1);
			}});
	}//End
	
	
	private void replyShape(final String strGroup, final String strStep){
		
		sql = "UPDATE spring_mvc_board "
				+ " SET bstep = bstep + 1"
				+ " WHERE bgroup = ? AND bstep  > ? ";

		template.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, Integer.parseInt(strGroup));
				pstmt.setInt(2, Integer.parseInt(strStep));
			}});
	}//End
	
}//End Class
