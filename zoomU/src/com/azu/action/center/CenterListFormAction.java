package com.azu.action.center;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.ad.AdForm;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;
import com.azu.model.CountVO;
import com.azu.model.FindVO;
import com.azu.model.HomeVO;

public class CenterListFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CenterDAO dao = CenterDAO.getInstance();
		// int
		int curPage=(request.getParameter("curPage")==null)?1:Integer.parseInt(request.getParameter("curPage"));
		
		// 검색 기능
		String search = request.getParameter("search");
		
		// 
		CountVO cvo = new CountVO();
		dao.countRecord(curPage);
		Vector<CenterVO> list = new Vector<CenterVO>();
		
		if (search == null || search.equals("")) {
			// 검색어가 없다.
			cvo = dao.countRecord(curPage);
			list = dao.selectList(cvo);
		} else {
			// 검색어가 있다.
			CenterVO center_vo = new CenterVO();
			center_vo.setcPetName(search);
			cvo = dao.countRecord_search(curPage, center_vo);
			list = dao.search(cvo, search);
		}
		
		request.setAttribute("cvo", cvo);
		request.setAttribute("list", list);
		
		// 광고 창
		AdForm ad = new AdForm();
		request.setAttribute("ad", ad.callAd());

		return "/dog/center/centerListForm.jsp";
	}
}
