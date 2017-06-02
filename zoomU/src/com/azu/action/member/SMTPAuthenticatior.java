package com.azu.action.member;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticatior extends Authenticator {	
	@Override
    protected PasswordAuthentication getPasswordAuthentication() {
	// 실제 자신 이메일, 비번 넣어야함
        return new PasswordAuthentication("아이디입력","비밀번호입력");
    }
}
