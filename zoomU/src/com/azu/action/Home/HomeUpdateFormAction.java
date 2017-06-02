package com.azu.action.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.azu.action.ICommandAction;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;

public class HomeUpdateFormAction implements ICommandAction {
	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HomeDAO dao=HomeDAO.getInstance();
		HomeVO vo =dao.selectContent(Integer.parseInt(request.getParameter("hnum")));
		request.setAttribute("vo", vo);
		return "/dog/Home/HomeUpdateForm.jsp";
	}
}
