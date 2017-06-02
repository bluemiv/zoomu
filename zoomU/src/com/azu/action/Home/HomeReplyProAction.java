package com.azu.action.Home;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;

public class HomeReplyProAction implements ICommandAction{

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 페이징 UTF-8 처리
		request.setCharacterEncoding("UTF-8");
		
		// 세션 아이디 가져옴
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// 저장
		ReplyVO vo = new ReplyVO();
		boolean check = false;
		
		if (id != null) {
			String content = request.getParameter("content");
			int hnum = Integer.parseInt(request.getParameter("hnum"));

			// 현재 시간 구하기
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar cal = Calendar.getInstance();
			String today = formatter.format(cal.getTime());
			Timestamp ts = Timestamp.valueOf(today);
			
			vo.setRdate(ts);
			vo.setBoard("home"); // 게시판 이름
			vo.setContent(content);
			vo.setRef(hnum);
			vo.setId(id);

			ReplyDAO dao = ReplyDAO.getInstance();
			check = dao.insertReply(vo);
		}
		
		request.setAttribute("vo", vo); // hnum
		request.setAttribute("check", check);

		return "/dog/Home/homeReplyPro.jsp";
	}

}
