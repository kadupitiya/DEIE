package org.deie.model;

public class User {

	private String userName;
	private String passwordHashed;
	


	public User(){
		
	}
	
	
	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPasswordHashed() {
		return passwordHashed;
	}




	public void setPasswordHashed(String passwordHashed) {
		this.passwordHashed = passwordHashed;
	}

	
}
