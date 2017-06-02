package com.azu.action.sos;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.ad.AdForm;
import com.azu.model.CountVO;
import com.azu.model.FindVO;
import com.azu.model.ReplyDAO;
import com.azu.model.ReplyVO;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

public class SosListFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		int count = 0;

		Vector<SosVO> list = new Vector<SosVO>(); // 출력할 VO 객체
		SosDAO dao = SosDAO.getInstance();

		ReplyDAO re_dao = ReplyDAO.getInstance();
		ReplyVO re_vo = new ReplyVO();

		// 페이징 처리
		int curPage = (request.getParameter("curPage") == null) ? 1 : Integer.parseInt(request.getParameter("curPage"));
		CountVO cvo = new CountVO();
		cvo = dao.countRecord(curPage);
		
		String search = request.getParameter("search");	// 검색어 가져옴
		
		if(search == null || search.equals("")){
			// 검색어가 없을때
			list = dao.selectList(cvo);
			
		} else {
			// 검색어가 있을때
			SosVO input_vo = new SosVO();
			input_vo.setStitle(search);
			cvo=dao.countRecord_search(curPage, input_vo);
			
			list = dao.search(cvo, input_vo);
		}

		// 조회수 가져옴
		count = dao.getListAllCount();

		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("cvo", cvo);

		// 광고 창
		AdForm ad = new AdForm();
		request.setAttribute("ad", ad.callAd());
		
		return "/dog/sos/sosListForm.jsp";
	}

}
