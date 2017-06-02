package com.azu.action.center;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;

public class CenterDeleteFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		String cId = (String) session.getAttribute("id");
		String cPwd = (String) session.getAttribute("pwd");
		
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		
		CenterVO vo = new CenterVO();
		vo.setcNum(cNum);
		vo.setcId(cId);
		vo.setcPwd(cPwd);
		
		CenterDAO dao = CenterDAO.getInstance();
		boolean check = dao.delete(vo);
		
		request.setAttribute("check", check);
		request.setAttribute("cNum", cNum);
		
		return "/dog/center/centerDeleteForm.jsp";
	}
	
}
