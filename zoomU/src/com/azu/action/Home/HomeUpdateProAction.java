package com.azu.action.Home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HomeUpdateProAction implements ICommandAction {
	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HomeVO vo = new HomeVO();

		String savePath = request.getServletContext().getRealPath("img/home");// ������
																				// ������
		int sizeLimit = 1024 * 1024 * 15;// ���� ���� ũ��
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());

		// 세션 ID PWD 가져옴
		HttpSession session = request.getSession();

		String fileName = multi.getFilesystemName("hPhoto");
		vo.setHnum(Integer.parseInt(multi.getParameter("hnum")));
		vo.setHpetname(multi.getParameter("hName"));
		vo.setHgender(multi.getParameter("hGender"));
		vo.setHtype(multi.getParameter("hType"));
		vo.setHphoto(fileName);
		vo.setHyn(multi.getParameter("hYn"));
		vo.setHetc(multi.getParameter("hEtc"));
		vo.setHid((String) session.getAttribute("id"));
		vo.setHpwd((String) session.getAttribute("pwd"));
		String m_fileFullPath = savePath + "/" + fileName;
		
		System.out.println("vo.getHpetname() : " + vo.getHpetname());
		System.out.println("vo.getHgender() : " + vo.getHgender());
		System.out.println("vo.getHtype() : " + vo.getHtype());
		System.out.println("vo.getHphoto() : " + vo.getHphoto());
		System.out.println("vo.getHyn() : " + vo.getHyn());
		System.out.println("vo.getHetc() : " + vo.getHetc());
		System.out.println("vo.getHid() : " + vo.getHid());
		System.out.println("vo.getHpwd() : " + vo.getHpwd());
		
		HomeDAO dao = HomeDAO.getInstance();
		boolean check = dao.update(vo);

		vo = dao.selectContent(Integer.parseInt(multi.getParameter("hnum")));
		
		request.setAttribute("vo", vo);
		request.setAttribute("check", check);

		// 로컬 저장소에 이미지 저장
		dao.img_copy(m_fileFullPath, fileName);

		return "/dog/Home/HomeContentForm.jsp";
	}
}
