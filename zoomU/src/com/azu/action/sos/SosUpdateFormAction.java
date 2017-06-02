package com.azu.action.sos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

public class SosUpdateFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 글 작성자가 맞는지 확인
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		// 글의 내부 번호 가져옴
		int snum = Integer.parseInt(request.getParameter("snum"));

		SosDAO dao = SosDAO.getInstance();
		SosVO input_vo = new SosVO();
		input_vo.setSnum(snum);
		
		// 글 작성자의 회원 정보를 가져옴
		SosVO vo = dao.select(input_vo);

		boolean check = false;
		if(vo.getSwriter().equals(id)){
			// 동일한 사람이면 수정 가능
			check = true;
			request.setAttribute("vo", vo);
		}
		
		request.setAttribute("check", check);
		
		return "/dog/sos/sosUpdateForm.jsp";
	}

}
