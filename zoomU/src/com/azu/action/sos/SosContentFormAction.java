package com.azu.action.sos;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

public class SosContentFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 부모 글 내용
		int countNum = Integer.parseInt(request.getParameter("countNum"));
		int snum = Integer.parseInt(request.getParameter("snum"));
		int checkCount = Integer.parseInt(request.getParameter("checkCount"));

		SosVO input_vo = new SosVO();
		input_vo.setSnum(snum);

		SosDAO dao = SosDAO.getInstance();

		dao.readcount(input_vo, checkCount);

		SosVO output_vo = dao.detail(input_vo);

		System.out.println("output_vo" + output_vo);

		// 부모글의 댓글 내용
		int ref_num = output_vo.getSnum();
		Vector<ReplyVO> re_list = new Vector<ReplyVO>();
		ReplyDAO re_dao = ReplyDAO.getInstance();
		re_list = re_dao.select(ref_num, "sos");

		// 값을 넘겨줌
		request.setAttribute("re_list", re_list);
		request.setAttribute("vo", output_vo);
		request.setAttribute("countNum", countNum);
		request.setAttribute("checkCount", checkCount);

		return "/dog/sos/sosContentForm.jsp";
	}

}
