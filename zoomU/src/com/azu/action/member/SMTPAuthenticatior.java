package com.azu.action.member;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticatior extends Authenticator {	
	@Override
    protected PasswordAuthentication getPasswordAuthentication() {
	// ���� �ڽ� �̸���, ��� �־����
        return new PasswordAuthentication("���̵��Է�","��й�ȣ�Է�");
    }
}
