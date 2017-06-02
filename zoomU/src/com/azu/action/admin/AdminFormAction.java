package com.azu.action.admin;

import java.util.Vector;

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

public class AdminFormAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Vector<CenterVO> center_list = new Vector<CenterVO>();
		Vector<HomeVO> home_list = new Vector<HomeVO>();
		Vector<FindVO> find_list = new Vector<FindVO>();
		Vector<SosVO> sos_list = new Vector<SosVO>();
		
		CenterDAO center_dao = CenterDAO.getInstance();
		HomeDAO home_dao = HomeDAO.getInstance();
		FindDAO find_dao = new FindDAO();
		SosDAO sos_dao = SosDAO.getInstance();
		
		center_list = center_dao.selectAll();
		home_list = home_dao.selectAll();
		find_list = find_dao.selectAll();
		sos_list = sos_dao.selectAll();
		
		request.setAttribute("center_list", center_list);
		request.setAttribute("home_list", home_list);
		request.setAttribute("find_list", find_list);
		request.setAttribute("sos_list", sos_list);
		
		return "/dog/admin/adminForm.jsp";
	}

}
