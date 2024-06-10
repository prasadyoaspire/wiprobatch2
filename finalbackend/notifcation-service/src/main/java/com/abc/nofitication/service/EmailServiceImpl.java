package com.abc.nofitication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.abc.nofitication.model.EmailDetails;


@Service
public class EmailServiceImpl implements EmailService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String emailSender;

	@Override
	public void sendEmail(EmailDetails emailDetails) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailSender);
			message.setTo(emailDetails.getRecipient());
			message.setText(emailDetails.getBody());
			message.setSubject(emailDetails.getSubject());
			
			mailSender.send(message);
			
			LOGGER.info("Mail sent successfully");
		} catch (MailException exception) {
			LOGGER.debug("Failure occurred while sending email");
		}
	}
	
	
}
