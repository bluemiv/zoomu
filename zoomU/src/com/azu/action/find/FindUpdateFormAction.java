package com.azu.action.find;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.FindDAO;
import com.azu.model.FindVO;

public class FindUpdateFormAction implements ICommandAction{

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int fNum = Integer.parseInt(request.getParameter("fNum"));
		
		// 세션에서 id, pwd값 가져옴
		HttpSession session = request.getSession();
		String fId = (String)session.getAttribute("id");
		String fPwd = (String)session.getAttribute("pwd");
		
		// select 인자값으로 들어감
		FindVO input_vo = new FindVO();
		input_vo.setfNum(fNum);
		
		FindDAO dao = new FindDAO();
		FindVO output_vo = dao.select(input_vo);
		
		boolean check = false; // 글 작성자와 동일한 사람인지 확인
		if(output_vo.getfId().equals(fId) && output_vo.getfPwd().equals(fPwd)){
			check = true;
		}
		
		// vo를 넘겨줌
		request.setAttribute("vo", output_vo);
		request.setAttribute("check", check);
		
		return "/dog/find/findUpdateForm.jsp";
	}

	
}
