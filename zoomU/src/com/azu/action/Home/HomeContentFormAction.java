package com.azu.action.Home;


import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;

public class HomeContentFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 부모글
		HomeDAO dao=HomeDAO.getInstance();
		HomeVO vo =dao.selectContent(Integer.parseInt(request.getParameter("hnum")));
		HttpSession session=request.getSession();
		boolean checkid=false;
		if(vo.getHid().equals((String)session.getAttribute("id"))) checkid=true;
		// 부모글의 댓글 내용
		int ref_num = vo.getHnum();
		Vector<ReplyVO> re_list = new Vector<ReplyVO>();
		ReplyDAO re_dao = ReplyDAO.getInstance();
		re_list = re_dao.select(ref_num, "home");
		// 값을 넘겨줌
		request.setAttribute("re_list", re_list);
		request.setAttribute("vo", vo);
		request.setAttribute("checkid", checkid);
		
		return "/dog/Home/HomeContentForm.jsp";
	}
}
