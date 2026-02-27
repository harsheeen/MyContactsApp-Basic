package com.seveneleven.mycontactsapp.contact;

import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.model.UserRepository;

public class Create_contact extends UserRepository{
	private String username;
	private String email;
	private String contact;
	private String password;
	
	
	public Create_contact(String username, String email, String password, String contact) {
		this.username=username;
		this.email=email;
		this.contact=contact;
		this.password=password;
	}
	public void add_user() {
	User new_user= new User(username,password,email);
	UserRepository.save(new_user);
	}
	
}