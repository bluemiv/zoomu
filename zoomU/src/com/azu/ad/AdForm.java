package com.azu.ad;

import java.util.Vector;

import com.azu.model.AdDAO;
import com.azu.model.AdVO;

public class AdForm {

	public AdVO callAd() throws Exception {

		Vector<AdVO> list = new Vector<AdVO>();
		AdDAO dao = AdDAO.getInstance();

		int total_money = dao.totalStackMoney(); // 총 기부 금액

		list = dao.enterNameList(); // 기부한 기업 객체

		int[] enterRate = new int[list.size()]; // 각 기업당 광고 확률
		for (int i = 0; i < list.size(); i++) {
			enterRate[i] = (int)((double) list.get(i).getaMoney() / total_money * 100);
			// 확률이 0% 일때는 1%로 늘려준다.
			if(enterRate[i] == 0){
				enterRate[i] = 1;
			}
		}
		
		// 누적 확률로 바꿔줌
		for (int i = 1; i < list.size(); i++) {
			enterRate[i] = enterRate[i-1] + enterRate[i];
		}
		AdVO vo = new AdVO();
		int rate = (int)(Math.random() * 100);
		for(int i = 0; i <list.size(); i++){
			if (rate < enterRate[i]){
				vo = list.get(i);
				break;
			}
		}
		
		return vo;
	}

}
