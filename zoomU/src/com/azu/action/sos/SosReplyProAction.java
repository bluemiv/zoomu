package com.azu.action.sos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;

public class SosReplyProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		int countNum = Integer.parseInt(request.getParameter("countNum"));
		int checkCount = Integer.parseInt(request.getParameter("checkCount"));//0
		
		checkCount=0;
		
		ReplyVO vo = new ReplyVO();
		boolean check = false;
		if (id != null) {
			String content = request.getParameter("content");
			int snum = Integer.parseInt(request.getParameter("snum"));

			// 현재 시간 구하기
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar cal = Calendar.getInstance();
			String today = formatter.format(cal.getTime());
			Timestamp ts = Timestamp.valueOf(today);
			
			vo.setRdate(ts);
			vo.setBoard("sos");
			vo.setContent(content);
			vo.setRef(snum);
			vo.setId(id);

			ReplyDAO dao = ReplyDAO.getInstance();
			check = dao.insertReply(vo);
		}

		request.setAttribute("vo", vo); // snum
		request.setAttribute("check", check);
		request.setAttribute("countNum", countNum);
		request.setAttribute("checkCount", checkCount);

		return "/dog/sos/sosReplyPro.jsp";
	}

}
