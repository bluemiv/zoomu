package com.azu.action.member;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.MemberDAO;
import com.azu.model.MemberVO;

public class InsertFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("email", request.getParameter("email"));
		
		return "/dog/member/insertForm.jsp";
	}

}
