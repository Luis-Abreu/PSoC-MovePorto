package com.example.moveporto;

public class User {
	
	public String fullName="";
	public String email="";
	public Passe currentpass=null;
	
	public User(String fullName, String email) {
		setFullName(fullName);
		setEmail(email);
	}
	public String getFullName() {
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public Passe getCurrentpass() {
		return currentpass;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCurrentpass(Passe currentpass) {
		this.currentpass = currentpass;
	}
	
	

}
