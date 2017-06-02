package com.azu.action.sos;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;

public class SosReplyDeleteAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 댓글 정보 값 가져옴
		String id = request.getParameter("id");
		Timestamp rdate = Timestamp.valueOf(request.getParameter("rdate"));
		
		// 댓글 삭제
		ReplyVO vo = new ReplyVO();
		vo.setId(id);
		vo.setRdate(rdate);
		
		ReplyDAO dao = ReplyDAO.getInstance();
		boolean check = dao.delete(vo);
		
		request.setAttribute("check", check);
		
		return "/dog/sos/sosReplyDelete.jsp";
	}

}
