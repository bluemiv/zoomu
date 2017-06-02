package com.azu.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;
import com.azu.model.FindDAO;
import com.azu.model.FindVO;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

public class AdminDeleteAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String board = request.getParameter("board");
		
		boolean check = false;
		if(board.equals("center")){
			// 보호소 분양 게시판
			int cNum = Integer.parseInt(request.getParameter("cNum")); // 내부 글번호 가져옴
			// 삭제할 게시글 셋팅
			CenterVO vo = new CenterVO();
			vo.setcNum(cNum);
			// 삭제
			CenterDAO dao = CenterDAO.getInstance();
			check = dao.deleteAdmin(vo); // 삭제 성공하면 true
			
		} else if(board.equals("home")){
			// 개인 분양 게시판
			int hnum = Integer.parseInt(request.getParameter("hnum"));
			// 삭제할 게시글 셋팅
			HomeVO vo = new HomeVO();
			vo.setHnum(hnum);
			// 삭제
			HomeDAO dao = HomeDAO.getInstance();
			check = dao.deleteAdmin(vo); // 삭제 성공하면 true
		} else if(board.equals("find")){
			// 강아지 찾아주세요 게시판
			int fNum = Integer.parseInt(request.getParameter("fNum"));
			// 삭제할 게시글 셋팅
			FindVO vo = new FindVO();
			vo.setfNum(fNum);
			// 삭제
			FindDAO dao = new FindDAO();
			check = dao.deleteAdmin(vo); // 삭제 성공하면 true
		} else if(board.equals("sos")){
			// SOS 게시판
			int snum = Integer.parseInt(request.getParameter("snum"));
			// 삭제할 게시글 셋팅
			SosVO vo = new SosVO();
			vo.setSnum(snum);
			// 삭제
			SosDAO dao = SosDAO.getInstance();
			check = dao.deleteAdmin(vo); // 삭제 성공하면 true
		}
		
		request.setAttribute("check", check);
		
		return "/dog/admin/adminDelete.jsp";
	}

}
