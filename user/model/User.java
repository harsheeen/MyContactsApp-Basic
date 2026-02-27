package com.seveneleven.mycontactsapp.user.model;

public class User {
private String username;
private String Password;
private String email;

public User(String username, String password,String email) {
	this.username=username;
	this.Password=password;
	this.email=email;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
