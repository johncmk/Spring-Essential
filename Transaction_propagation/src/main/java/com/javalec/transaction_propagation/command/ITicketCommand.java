package com.javalec.transaction_propagation.command;

import com.javalec.transaction_propagation.dto.TicketDto;

public interface ITicketCommand {

	public void execute(TicketDto ticketDto);
}
