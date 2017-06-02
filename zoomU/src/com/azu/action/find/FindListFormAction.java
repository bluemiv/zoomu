package com.azu.action.find;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.ad.AdForm;
import com.azu.model.CountVO;
import com.azu.model.FindDAO;
import com.azu.model.FindVO;
import com.azu.model.HomeVO;

public class FindListFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Vector<FindVO> list = new Vector<FindVO>();
		FindDAO dao = new FindDAO();
		int curPage=(request.getParameter("curPage")==null)?1:Integer.parseInt(request.getParameter("curPage"));
		CountVO cvo = new CountVO();
		cvo=dao.countRecord(curPage);
		
		String search = request.getParameter("search");
		
		if(search == null || search.equals("")){
			// 검색어가 없을때
			list = dao.selectList(cvo);
			
		} else {
			// 검색어가 있을때
			FindVO input_vo = new FindVO();
			input_vo.setfPetName(search);
			cvo=dao.countRecord_search(curPage, input_vo);
			
			list = dao.search(cvo, input_vo);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("cvo", cvo);
		
		// 광고 창
		AdForm ad = new AdForm();
		request.setAttribute("ad", ad.callAd());
		
		return "/dog/find/findListForm.jsp";
	}

}
