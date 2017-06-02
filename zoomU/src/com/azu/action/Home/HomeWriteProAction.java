package com.azu.action.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.HomeVO;
import com.azu.model.HomeDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HomeWriteProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HomeVO vo = new HomeVO();
		String savePath = request.getServletContext().getRealPath("img/home");// ������
																				// ������
		int sizeLimit = 1024 * 1024 * 15;// ���� ���� ũ��
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());

		/*
		 * vo.setHpetname(request.getParameter("hName"));
		 * vo.setHgender(request.getParameter("hGender"));
		 * vo.setHtype(request.getParameter("hType"));
		 * vo.setHphoto(request.getParameter("hPhoto"));
		 * vo.setHyn(request.getParameter("hYn"));
		 * vo.setHetc(request.getParameter("hEtc")); vo.setHid("test");
		 * vo.setHpwd("test");
		 */
		HttpSession session = request.getSession();
		String fileName = multi.getFilesystemName("hPhoto");
		vo.setHpetname(multi.getParameter("hName"));
		vo.setHgender(multi.getParameter("hGender"));
		vo.setHtype(multi.getParameter("hType"));
		vo.setHphoto(fileName);
		vo.setHyn(multi.getParameter("hYn"));
		vo.setHetc(multi.getParameter("hEtc"));

		vo.setHid((String) session.getAttribute("id"));
		vo.setHpwd((String) session.getAttribute("pwd"));
		String m_fileFullPath = savePath + "/" + fileName;
		HomeDAO dao = HomeDAO.getInstance();
		boolean check = dao.insert(vo);
		
		request.setAttribute("check", check);
		
		dao.img_copy(m_fileFullPath, fileName);
		
		return "/dog/Home/HomeWritePro.jsp";
	}
}
