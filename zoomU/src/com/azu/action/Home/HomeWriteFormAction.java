package com.azu.action.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.azu.action.ICommandAction;
public class HomeWriteFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "/dog/Home/HomeWriteForm.jsp";
	}

}
