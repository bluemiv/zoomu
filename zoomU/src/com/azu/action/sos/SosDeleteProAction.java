package com.azu.action.sos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

public class SosDeleteProAction implements ICommandAction{

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 글 작성자가 맞는지 확인
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); // 글삭제 버튼을 누른 사용자의 정보
		
		int snum = Integer.parseInt(request.getParameter("snum"));
		
		SosDAO dao = SosDAO.getInstance();
		SosVO input_vo = new SosVO();
		SosVO output_vo = new SosVO(); // 글 작성자의 정보
		input_vo.setSnum(snum);
		output_vo = dao.select(input_vo);
		
		boolean check = false;
		if(output_vo.getSwriter().equals(id)) {
			// 사용자와 글 작성자가 동일인물이다.
			check = dao.delete(input_vo);
			System.out.println("실행?2");
		}
		
		request.setAttribute("check", check);
		
		return "/dog/sos/sosDeletePro.jsp";
	}
	
}
