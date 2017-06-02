package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class DeleteProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		if (session.getAttribute("id") == null) {
			return "/dog/member/loginForm.jsp";
		}
		String mid = (String) session.getAttribute("id");
		String mpwd = request.getParameter("mpwd");

		MemberVO vo = new MemberVO();
		vo.setMid(mid);
		vo.setMpwd(mpwd);

		MemberDAO dao = new MemberDAO();
		boolean check = dao.delete(vo);

		if (check) {
			session.invalidate();
		}

		request.setAttribute("check", check);
		
		return "/dog/member/deletePro.jsp";

	}

}
