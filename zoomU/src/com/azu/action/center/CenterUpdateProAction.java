package com.azu.action.center;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.CenterDAO;
import com.azu.model.CenterVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CenterUpdateProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	
		HttpSession session = request.getSession();
		String cId = (String) session.getAttribute("id");
		String cPwd = (String) session.getAttribute("pwd");
		
		//사진파일..
		String savePath = request.getServletContext().getRealPath("img/center");//서버의 절대경로
		int sizeLimit = 1024 * 1024 * 15;//파일 리밋 크기
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",new DefaultFileRenamePolicy());
		
		int cNum = Integer.parseInt(multi.getParameter("cNum"));
		String cPetName = multi.getParameter("cPetName");
		String cGender = multi.getParameter("cGender");
		String cType = multi.getParameter("cType");
		String cArea = multi.getParameter("cArea");
		String cName = multi.getParameter("cName");
		String fileName = multi.getFilesystemName("Cphoto");
		String cYn = multi.getParameter("cYn");
		String cEtc = multi.getParameter("cEtc");
		
		
		/*vo.setcNum(Integer.parseInt(multi.getParameter("cNum")));
		vo.setcPetName(multi.getParameter("cPetName"));
		vo.setcGender(multi.getParameter("cGender"));
		vo.setcType(multi.getParameter("cType"));
		vo.setcArea(multi.getParameter("cArea"));
		vo.setcName(multi.getParameter("cName"));
		vo.setCphoto(fileName);
		vo.setcYn(multi.getParameter("cYn"));
		vo.setcEtc(multi.getParameter("cEtc"));*/
		
		
		
		boolean check = false;
		if("admin".equals(cId)){ //글작성자가 맞는지 확인한곳...
			
		String m_fileFullPath = savePath + "/" + fileName;
		
		CenterVO vo = new CenterVO();
		
		vo.setcPetName(cPetName);
		vo.setcGender(cGender);
		vo.setcType(cType);
		vo.setcArea(cArea);
		vo.setcName(cName);
		vo.setCphoto(fileName);
		vo.setcYn(cYn);
		vo.setcEtc(cEtc);
		vo.setcNum(cNum);
		
		vo.setcId(cId); 
		vo.setcPwd(cPwd); 
		
			
		CenterDAO dao = CenterDAO.getInstance();
		dao.update(vo); //실제 변경 내용 반영함수 호출
		
		dao.img_copy(m_fileFullPath, fileName);// 서버에 있는 이미지를 local 저장소에 복사
	}		
		
		request.setAttribute("check", check);
		
		return "/dog/center/centerUpdatePro.jsp";
	}	
}
