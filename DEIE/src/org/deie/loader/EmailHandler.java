package org.deie.loader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.deie.model.Message;

public class EmailHandler {
	
	private final String DEPARTMENT_EMAIL = "";	

	public Message contactUs(HttpServletRequest request) {
		Message message = new Message();
		
		String sender, email, subject, content;
		
		
		sender=request.getParameter("sender"); 
		email=request.getParameter("email"); 
		subject=request.getParameter("subject");
		content=request.getParameter("content");
		
		
		if (sendEmail( sender,  email,  subject,  content)) {
			
			message.setCondition(true);
			message.setMessage("Your message was successfully sent!");

		} else {
			
			message.setCondition(false);
			message.setMessage("Email client failed");

		}

		return message;

	}
	
	protected boolean sendEmail(String sender, String email, String subject, String content){
		
		
		return false;
		
		
		
	}
	

}
