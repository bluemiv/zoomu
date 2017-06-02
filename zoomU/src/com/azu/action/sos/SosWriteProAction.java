package com.azu.action.sos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.SosDAO;
import com.azu.model.SosVO;

import oracle.net.aso.s;

public class SosWriteProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글깨짐 처리
		request.setCharacterEncoding("utf-8");
		
		// 세션 ID 값 가져오리
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		SosVO vo= new SosVO();
		String[] sarea_temp = request.getParameterValues("sarea");
		String sarea = sarea_temp[0] + " " +sarea_temp[1];
		vo.setSarea(sarea);
		vo.setStitle(request.getParameter("stitle"));
		vo.setStell(request.getParameter("stell"));
		// 현재 시간 구하기
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		vo.setSdate(ts);
		// 세션 ID
		vo.setSwriter(id);
		vo.setSetc(request.getParameter("setc"));
		
		// 게시물 삽입
		SosDAO dao=SosDAO.getInstance();
		dao.insert(vo);
		
		return "/dog/sos/sosWritePro.jsp";
	}
 
}
