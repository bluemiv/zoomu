package com.azu.action.center;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;
import com.azu.model.HomeDAO;
import com.azu.model.HomeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CenterWriteProAction implements ICommandAction{

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String cId = (String) session.getAttribute("id");
		String cPwd = (String) session.getAttribute("pwd");
		
		String savePath = request.getServletContext().getRealPath("img/center");//서버의 절대경로
		int sizeLimit = 1024 * 1024 * 15;//파일 리밋 크기
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",new DefaultFileRenamePolicy());
		
		String cPetName = multi.getParameter("cPetName");
		String cGender = multi.getParameter("cGender");
		String cType = multi.getParameter("cType");
		String cArea = multi.getParameter("cArea");
		String cName = multi.getParameter("cName");
		String fileName = multi.getFilesystemName("Cphoto");
		String cYn = multi.getParameter("cYn");
		String cEtc = multi.getParameter("cEtc");
		
		/*vo.setcName(multi.getParameter("cName"));
		vo.setcGender(multi.getParameter("cGender"));
		vo.setcType(multi.getParameter("cType"));
		vo.setcPetName(multi.getParameter("cPetName"));
		vo.setCphoto(fileName);
		vo.setcYn(multi.getParameter("cYn"));		
		vo.setcEtc(multi.getParameter("cEtc"));
		vo.setcArea(multi.getParameter("cArea"));
		*/
		
		String m_fileFullPath = savePath + "/" + fileName;
		CenterDAO dao = CenterDAO.getInstance();
		
		CenterVO vo = new CenterVO();
		//set
		vo.setcPetName(cPetName);
		vo.setcGender(cGender);
		vo.setcType(cType);
		vo.setcArea(cArea);
		vo.setcName(cName);
		vo.setCphoto(fileName);
		vo.setcYn(cYn);
		vo.setcEtc(cEtc);
		vo.setcId(cId); 
		vo.setcPwd(cPwd);		
		
		boolean check=dao.insert(vo);
		request.setAttribute("check", check);
		
		dao.img_copy(m_fileFullPath, fileName);
		
		return "/dog/center/centerWritePro.jsp";
	}
	
}
