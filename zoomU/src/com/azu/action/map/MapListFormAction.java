package com.azu.action.map;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.ad.AdForm;
import com.azu.model.MapDAO;
import com.azu.model.MapVO;

public class MapListFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String mArea = request.getParameter("mArea");
		String mCenterName = request.getParameter("mCenterName");
		boolean check = false;
		Vector<MapVO> list = new Vector<MapVO>();
		MapVO input_vo = new MapVO();
		MapDAO dao = MapDAO.getInstance();
		
		if(mArea != null && mCenterName == null){
			input_vo.setmArea(mArea);
			
		} else if(mArea != null && mCenterName != null) {
			input_vo.setmArea(mArea);
			input_vo.setmCenterName(mCenterName);
			
			check = true;
		}

		list = dao.selectAll(input_vo);
		request.setAttribute("list", list);
		request.setAttribute("mArea", mArea);
		request.setAttribute("check", check);
		
		// 광고 창
		AdForm ad = new AdForm();
		request.setAttribute("ad", ad.callAd());
		
		return "/dog/map/mapListForm.jsp";
	}

}
