package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class UpdateFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		// 1. 로그인 여부 조사
		HttpSession session = request.getSession();

		// 2. session에 저장된 id 호출
		String mid = (String) session.getAttribute("id");

		MemberVO input_vo = new MemberVO();
		input_vo.setMid(mid);
		
		// 3. MemberDao의 getMember 메서드에 id 전달
		MemberDAO dao = new MemberDAO();
		
		MemberVO output_vo = dao.select(input_vo);

		// 4.반환받은 Member를 request에 저장
		request.setAttribute("vo", output_vo);

		return "/dog/member/updateForm.jsp";
	}

}
