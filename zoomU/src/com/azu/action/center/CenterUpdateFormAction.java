package com.azu.action.center;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;

public class CenterUpdateFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	
		HttpSession session = request.getSession();
		String cId = (String) session.getAttribute("id");
		String cPwd = (String) session.getAttribute("pwd");
		
		CenterDAO dao=CenterDAO.getInstance();
		CenterVO vo = new CenterVO();
		
		vo = dao.selectupdate(Integer.parseInt(request.getParameter("cNum")));
		
		boolean check = false;
		if(vo.getcId().equals(cId) && vo.getcPwd().equals(cPwd)){
			check= true;
		}
						
		request.setAttribute("vo", vo);
		request.setAttribute("check", check);
		return "/dog/center/centerUpdateForm.jsp";
	}	
}
