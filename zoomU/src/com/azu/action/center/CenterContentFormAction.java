package com.azu.action.center;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;

public class CenterContentFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 부모 게시판 글
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		
		CenterDAO dao = CenterDAO.getInstance();
		CenterVO vo = new CenterVO();
		vo = dao.Detail(cNum);
		
		// 부모글의 댓글 내용
		int ref_num = vo.getcNum();
		Vector<ReplyVO> re_list = new Vector<ReplyVO>();
		ReplyDAO re_dao = ReplyDAO.getInstance();
		re_list = re_dao.select(ref_num, "center");

		// 값을 넘겨줌
		request.setAttribute("re_list", re_list);
		request.setAttribute("vo", vo);
		
		return "/dog/center/centerContentForm.jsp";
	}
	
	
}
