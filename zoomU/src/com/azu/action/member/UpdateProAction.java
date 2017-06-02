package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class UpdateProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("id");
		
		String mpwd =request.getParameter("mpwd");
		String mname =request.getParameter("mname");
		String mtel =request.getParameter("mtel");
		String maddr =request.getParameter("maddr");
		String memail =request.getParameter("memail");
		
		//받은 값을 VO에 세팅
		MemberVO vo =new MemberVO();
		vo.setMid(mid);
		vo.setMpwd(mpwd);
		vo.setMname(mname);
		vo.setMtel(mtel);
		vo.setMaddr(maddr);
		vo.setMemail(memail);
		
		//update 불러오기
		MemberDAO dao= new MemberDAO();
		boolean check =  dao.update(vo);
		
		request.setAttribute("check", check);
		
		return "/dog/member/updatePro.jsp";
	}

}
