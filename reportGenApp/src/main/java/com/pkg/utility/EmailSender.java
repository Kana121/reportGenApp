package com.pkg.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailSender {

	private JavaMailSender mailSender;
	
	public boolean sendMail(String subject,String body,String to) {
		try {
		MimeMessage mimeMessage	=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
		helper.setSubject(subject);
		helper.setText(body,true);
		helper.setTo(to);
		
		mailSender.send(mimeMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
}
