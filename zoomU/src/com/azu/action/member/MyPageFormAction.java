package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class MyPageFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		// 세션 값 가져오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pwd = (String)session.getAttribute("pwd");
		
		MemberVO input_vo = new MemberVO();
		input_vo.setMid(id);
		input_vo.setMpwd(pwd);
		
		MemberVO output_vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		output_vo = dao.select(input_vo);
		
		// 세션값 넘기기
		request.setAttribute("vo",output_vo);
		
		
		return "/dog/member/myPageForm.jsp";
	}

}
