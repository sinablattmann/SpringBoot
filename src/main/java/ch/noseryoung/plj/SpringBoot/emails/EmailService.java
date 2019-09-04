package ch.noseryoung.plj.SpringBoot.emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService{
	
	public JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendSimpleEmail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email.getTo()); 
        message.setSubject(email.getSubject()); 
        message.setText(email.getText());
        javaMailSender.send(message);
	}
}
