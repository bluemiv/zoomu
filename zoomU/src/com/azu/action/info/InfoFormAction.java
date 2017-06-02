package com.azu.action.info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.ad.AdForm;

public class InfoFormAction implements ICommandAction{

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 광고 창
		AdForm ad = new AdForm();
		request.setAttribute("ad", ad.callAd());
		
		return "/dog/info/infoForm.jsp";
	}

	
}
