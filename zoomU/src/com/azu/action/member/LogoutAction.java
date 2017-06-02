package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;

public class LogoutAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session =request.getSession();
		session.invalidate();

		return"/dog/member/logout.jsp";
	}

}
