package com.wcs.app.model;

public class EmailSender {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textmsg;
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	private byte[] file;
	
	public String getTextmsg() {
		return textmsg;
	}
	public void setTextmsg(String textmsg) {
		this.textmsg = textmsg;
	}
	
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
