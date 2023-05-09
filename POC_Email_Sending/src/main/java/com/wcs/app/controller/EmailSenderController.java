package com.wcs.app.controller;

import javax.mail.internet.MimeMessage;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wcs.app.model.EmailSender;
import com.wcs.app.service.EmailSenderService;

@RestController
public class EmailSenderController {
	@Autowired
	EmailSenderService ess;

	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping(value = "/sendemail")// http://localhost:2233/sendemail
	public String EmailSend(@RequestBody EmailSender eml) {
		eml.setFromEmail(fromEmail);
		try {
			ess.sendEmail(eml);
			return "Emailsend";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Email can not sent";
		}
	}
	
	  @PostMapping(value = "/sendemailwithattch") 
	  public String sendEmailAttachement(@RequestBody EmailSender eml)
	  {
	  eml.setFromEmail(fromEmail); 
	  
	  return ess.sendEmailAttachement(eml); 
	  }
	
}
