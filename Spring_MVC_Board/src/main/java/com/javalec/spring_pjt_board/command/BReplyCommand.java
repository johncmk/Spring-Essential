package com.javalec.spring_pjt_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bid = request.getParameter("bId");
		String bname = request.getParameter("bName");
		String btitle = request.getParameter("bTitle");
		String bcontent = request.getParameter("bContent");
		String bgroup = request.getParameter("bGroup");
		String bstep = request.getParameter("bStep");
		String bindent = request.getParameter("bIndent");
	
		BDao dao = new BDao();
		dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
	}

}
