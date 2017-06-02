package com.azu.action.sos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

public class SosUpdateProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");

		int snum = Integer.parseInt(request.getParameter("snum"));

		SosVO vo = new SosVO();
		vo.setSnum(snum);
		vo.setSarea(request.getParameter("sarea"));
		vo.setStell(request.getParameter("stell"));
		vo.setStitle(request.getParameter("stitle"));
		vo.setSetc(request.getParameter("setc"));
		vo.setSwriter(request.getParameter("swriter"));

		SosDAO dao = SosDAO.getInstance();

		dao.update(snum, vo);
		request.setAttribute("snum", snum);
		request.setAttribute("vo", vo);

		return "/dog/sos/sosUpdatePro.jsp";
	}

}
