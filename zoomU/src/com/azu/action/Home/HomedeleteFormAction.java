package com.azu.action.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;
import com.azu.model.MemberDAO;

public class HomedeleteFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*HomeDAO dao=HomeDAO.getInstance();
		dao.delete(request.getParameter("hnum"));
		return "/dog/Home/HomedeleteForm.jsp";*/

		HttpSession session=request.getSession();
		HomeDAO dao=HomeDAO.getInstance();
		HomeVO vo=new HomeVO();
		vo.setHnum(Integer.parseInt(request.getParameter("hnum")));
		vo.setHid((String)session.getAttribute("id"));		
		boolean check=dao.delete(vo);
		request.setAttribute("check", check);
		return "/dog/Home/HomedeleteForm.jsp";
	}

}
