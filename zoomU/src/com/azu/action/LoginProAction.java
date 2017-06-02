package com.azu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/dog/loginPro.jsp";
	}

}
