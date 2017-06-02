package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class CheckDuplicationIdAction implements ICommandAction {
	
	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid").trim();
		String result = "N";
		
		MemberVO vo = new MemberVO();
		vo.setMid(mid);

		MemberDAO dao = new MemberDAO();
		boolean check = dao.confirmId(vo);

		if (check) {
			result="Y";	// 사용가능
		}
		
		//idcheck.jsp로 값을 넘김
		request.setAttribute("result", result);
		
		return "/dog/member/idcheck.jsp";

	}
}
