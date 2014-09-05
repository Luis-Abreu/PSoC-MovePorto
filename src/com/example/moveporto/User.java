package com.example.moveporto;

public class User {
	
	String fullName;
	String email;
	Passe currentpass=null;
	
	public User(String fullName, String email) {
		setFullName(fullName);
		setEmail(email);
	}
	private String getFullName() {
		return fullName;
	}
	private String getEmail() {
		return email;
	}
	private Passe getCurrentpass() {
		return currentpass;
	}
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	private void setCurrentpass(Passe currentpass) {
		this.currentpass = currentpass;
	}	
	
	

}
