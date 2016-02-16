package com.javalec.transaction_template.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.transaction_template.dto.TicketDto;

public class TicketDao {

	private JdbcTemplate template;
	private TransactionTemplate transactionTemplate;
	
	private String sql = null;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public TicketDao() {
		System.out.println(template);
	}
	
	/**
	 * If one of the SQL execution fails then it will rollback. Otherwise it will commit;
	 * @param dto
	 */
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());

		transactionTemplate.execute(new TransactionCallbackWithoutResult(){

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				
				//SQL1
				sql = "INSERT INTO card(consumerId, amount) "
						+ " values(?, ?)";

				template.update(sql,new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						// TODO Auto-generated method stub
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
					}
				});
				//End SQL1
				
				//SQL2
				sql = "INSERT INTO ticket(consumerId, countnum) "
						+ " values(?, ?)";
				
				template.update(sql, new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						// TODO Auto-generated method stub
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
					}
				});
				//End SQL2
				
			}//End TransactionCallbackWithoutResult
		});//End TransactionTemplate
	}//End		
	
}//End
