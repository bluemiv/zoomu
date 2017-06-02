package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class InsertProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String mid= request.getParameter("mid");
		String mpwd =request.getParameter("mpwd");
		String mname =request.getParameter("mname");
		String mtel =request.getParameter("mtel");
		String maddr =request.getParameter("maddr");
		String memail =request.getParameter("memail");
		
		System.out.println(mid+mpwd+mname+mtel+maddr+memail);
		
		//받은 값을 VO에 세팅
		MemberVO vo =new MemberVO();
		vo.setMid(mid);
		vo.setMpwd(mpwd);
		vo.setMname(mname);
		vo.setMtel(mtel);
		vo.setMaddr(maddr);
		vo.setMemail(memail);
		
		//insert 불러오기
		MemberDAO dao= new MemberDAO();
	   boolean check =  dao.insert(vo);
		
	   //insertPro.jsp로 값을 넘김
	   request.setAttribute("check", check);
				
		return "/dog/member/insertPro.jsp";
	}

}
