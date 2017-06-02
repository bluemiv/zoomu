package com.azu.action.Home;


import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.ad.AdForm;
import com.azu.model.CountVO;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;

public class HomeListFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HomeDAO dao=HomeDAO.getInstance();
		int curPage=(request.getParameter("curPage")==null)?1:Integer.parseInt(request.getParameter("curPage"));
		CountVO cvo=dao.countRecord(curPage);		
		Vector<HomeVO> list=dao.selectList(cvo);		
		String search = request.getParameter("search");		
		if(search == null || search.equals("")){
			// 검색어가 없을때
			list = dao.selectList(cvo);
		} else {
			// 검색어가 있을때
			HomeVO home_vo = new HomeVO();
			home_vo.setHpetname(search);
			cvo=dao.countRecord_search(curPage, home_vo);			
			list = dao.search(cvo, home_vo);
		}
		request.setAttribute("cvo", cvo);
		request.setAttribute("list", list);	
		// 광고 창
		AdForm ad = new AdForm();
		request.setAttribute("ad", ad.callAd());
		return "/dog/Home/homeListForm.jsp";
	}
}
