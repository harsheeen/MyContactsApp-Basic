package com.seveneleven.mycontactsapp.auth;

import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.model.UserRepository;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHasher;

public class BasicAuth implements Authentication { 
	@Override public User login(String email, String password) { 
		User user = UserRepository.findByEmail(email); 
		if (user != null) { String hashedInput = PasswordHasher.hash(password); 
		if (hashedInput.equals(PasswordHasher.hash(password))) 
{ return user;
} 
} return null; // login failed } }
	}
}
