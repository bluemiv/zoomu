package com.azu.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import com.azu.action.ICommandAction;
import java.util.Properties;
import javax.mail.Authenticator;
public class EmailProAction implements ICommandAction {

	@Override
	public String doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		request.setCharacterEncoding("utf-8");
		String authority="";
		for(int i=0;i<8;i++) {
			char ch = (char) ((Math.random() * 26) + 65);
			authority+=ch;
		}
		System.out.println(authority);
		String from = "7538518@naver.com"; // 실제 자신의 이메일 주소 수정
		String to = request.getParameter("to");
		String subject = "ZoomU 인증 번호 발송 메일 ";
		String content = "인증 번호 : " +authority;
	
		Properties p = new Properties(); 
		p.put("mail.smtp.host","smtp.naver.com"); 
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
	
		try{
		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, auth);
		    ses.setDebug(true);
		    MimeMessage msg = new MimeMessage(ses);
		    msg.setSubject(subject);
		   
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); 
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // �޴� ���
		    msg.setContent(content, "text/html;charset=UTF-8"); // ����� ���ڵ�
		    
		    Transport.send(msg); 
		} catch(Exception e){
		    e.printStackTrace();
		} 
		request.setAttribute("authority", authority);
		request.setAttribute("email", to);
		
		return "/dog/member/memberEmailProAutho.jsp";
	}

}
