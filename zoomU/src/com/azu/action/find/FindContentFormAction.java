package com.azu.action.find;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.FindDAO;
import com.azu.model.FindVO;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;

public class FindContentFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 부모 글 내용
		int fNum = Integer.parseInt(request.getParameter("fNum"));
		
		FindVO input_vo = new FindVO();// select 인자값으로 들어감
		input_vo.setfNum(fNum);
		
		FindDAO dao = new FindDAO();
		FindVO output_vo = dao.select(input_vo);// 출력할 정보를 저장한 VO 객체
		
		// 부모글의 댓글 내용
		int ref_num = output_vo.getfNum();
		Vector<ReplyVO> re_list = new Vector<ReplyVO>();
		ReplyDAO re_dao = ReplyDAO.getInstance();
		re_list = re_dao.select(ref_num, "find");

		// 값을 넘겨줌
		request.setAttribute("re_list", re_list);
		request.setAttribute("vo", output_vo);
		
		return "/dog/find/findContentForm.jsp";
	}

}
