package com.azu.action.find;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azu.action.ICommandAction;
import com.azu.model.FindDAO;
import com.azu.model.FindVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FindUpdateProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 세션에서 id, pwd값 가져옴
		HttpSession session = request.getSession();
		String fId = (String)session.getAttribute("id");
		String fPwd = (String)session.getAttribute("pwd");
		
		// 파일이 저장될 서버의 경로
		String savePath = request.getServletContext().getRealPath("img/find");

		// 파일 크기 : 15MB
		int sizeLimit = 1024 * 1024 * 15;

		// (HttpServletRequest request, String saveDirectory, int maxPostSize,
		// String encoding, FileRenamePolicy policy)
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());

		int fNum = Integer.parseInt(multi.getParameter("fNum"));
		String fileName = multi.getFilesystemName("fPhoto");
		String fPetName = multi.getParameter("fPetName");
		String fType = multi.getParameter("fType");
		String fGender = multi.getParameter("fGender");
		String fDate = multi.getParameter("fDate") + " 00:00:00";
		Timestamp fDate_result = Timestamp.valueOf(fDate);
		String fArea = multi.getParameter("fArea");
		String fTel = multi.getParameter("fTel");
		String fEtc = multi.getParameter("fEtc");

		
		String confirm_id = multi.getParameter("confirm_id"); // 글 작성자 아이디
		
		boolean check = false;
		
		if(confirm_id.equals(fId)){ // 세션값과 글 작성자가 맞는지 확인
			// 업로드한 파일의 전체 경로
			String m_fileFullPath = savePath + "/" + fileName;
			// System.out.println(m_fileFullPath);
			
			// 데이터 set
			FindVO vo = new FindVO();
			vo.setfNum(fNum);
			vo.setfPetName(fPetName);
			vo.setfType(fType);
			vo.setfGender(fGender);
			vo.setfDate(fDate_result);
			vo.setfArea(fArea);
			vo.setfId(fId); // 세션에서 가져온 ID
			vo.setfPwd(fPwd); // 세션에서 가져온 PWD
			vo.setfTel(fTel);
			vo.setfPhoto(fileName);
			vo.setfEtc(fEtc);

			FindDAO dao = new FindDAO();
			check = dao.update(vo);

			// 서버에 있는 이미지를 local 저장소에 복사
			dao.img_copy(m_fileFullPath, fileName);
		}
		
		request.setAttribute("check", check);
		

		return "/dog/find/findUpdatePro.jsp";
	}

}
