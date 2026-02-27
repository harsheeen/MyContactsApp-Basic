package com.seveneleven.mycontactsapp.user.model;


public class UserValidator { 
	public static boolean isValidEmail(String email) { 
		return email.matches("^[A-Za-z0-9+_.-]+@(.+)$"); 
		} 
	}
