package com.javalec.transaction_ex.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javalec.transaction_ex.dto.TicketDto;

public class TicketDao {

	private String sql = null;
	private JdbcTemplate template;
	private PlatformTransactionManager transactionManager;
	
	public TicketDao() {
		System.out.println(template);
	}
	
	//Set in bean
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//set in bean
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	
	/**
	 * Buy Tickets
	 * @param dto
	 */
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getCosumerId(): " + dto.getConsumerId());
		System.out.println("dto.getAmount(): " + dto.getAmount());
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = this.transactionManager.getTransaction(definition);
		
		try {
			
			sql = "INSERT INTO card (consumerid, amount)"
					+ " values ( ?, ?)";
			
			template.update(sql, new PreparedStatementSetter(){
				
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
				}});
			
			sql = "INSERT INTO ticket (consumerid, countnum) "
					+ " values( ?, ? )";
			
			template.update(sql, new PreparedStatementSetter(){
				
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
				}});
	
			//Commit if both SQL worked successfully
			transactionManager.commit(status);
		} catch (Exception e) {
			//If any one of the SQL statements fail then rollback
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		
	}//End
	
	
}//End Class
