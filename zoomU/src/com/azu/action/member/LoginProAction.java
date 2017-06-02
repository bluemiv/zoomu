package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class LoginProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String mid= request.getParameter("mid"); // 아이디
		String mpwd = request.getParameter("mpwd"); // 비밀번호 loginForm.jsp로부터 받아옴
		
		// 받은 값을 VO에 세팅
		MemberVO vo = new MemberVO();
		vo.setMid(mid);
		vo.setMpwd(mpwd);
		
		//  유저 체크
		MemberDAO dao = new MemberDAO();
		boolean check = dao.userCheck(vo);
		
		// loginPro.jsp로 값을 넘김
		request.setAttribute("check", check);
		
		if(check){
			HttpSession session = request.getSession();
			session.setAttribute("id", mid);
			session.setAttribute("pwd", mpwd);
		}
		
		return "/dog/member/loginPro.jsp";
	}

}
