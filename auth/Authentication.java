package com.seveneleven.mycontactsapp.auth;

import com.seveneleven.mycontactsapp.user.model.User;

public interface Authentication {
	User login(String email, String password);
}
