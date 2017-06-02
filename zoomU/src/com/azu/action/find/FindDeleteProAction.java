package com.azu.action.find;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.FindDAO;
import com.azu.model.FindVO;

public class FindDeleteProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 세션에서 id, pwd값 가져옴
		HttpSession session = request.getSession();
		String fId = (String)session.getAttribute("id");
		String fPwd = (String)session.getAttribute("pwd");
		
		// 삭제할 게시글 내부 번호 (DB)
		int fNum = Integer.parseInt(request.getParameter("fNum"));
		
		FindVO vo = new FindVO();
		vo.setfNum(fNum);
		vo.setfId(fId);
		vo.setfPwd(fPwd);
		
		FindDAO dao = new FindDAO();
		boolean check = dao.delete(vo);
		
		request.setAttribute("check", check);
		
		return "/dog/find/findDeletePro.jsp";
	}

}
