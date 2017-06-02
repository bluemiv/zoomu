package com.azu.ad;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;
import com.azu.model.AdDAO;
import com.azu.model.AdVO;

public class AdProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("실행?");
		boolean check = false;
		// 기업 이름 가져오기
		String aEnterName = request.getParameter("aEnterName");
		// 기부금액 가져오기
		String aMoney_temp = request.getParameter("aMoney");
		if (aMoney_temp != null) {
			// null 값은 Integer로 못 바꿈
			int aMoney = Integer.parseInt(aMoney_temp);
			// 현재 시간 구하기
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar cal = Calendar.getInstance();
			String today = formatter.format(cal.getTime());
			Timestamp ts = Timestamp.valueOf(today);
			// 특이사항 값 가져오기
			String aEtc = request.getParameter("aEtc");

			// vo 객체에 값 저장
			AdVO vo = new AdVO();
			vo.setaDate(ts);
			vo.setaEnterName(aEnterName);
			vo.setaEtc(aEtc);
			vo.setaMoney(aMoney);
			
			// DB에 값 저장
			AdDAO dao = AdDAO.getInstance();
			check = dao.insert(vo);
		}

		request.setAttribute("check", check);

		return "/dog/ad/adPro.jsp";
	}

}
