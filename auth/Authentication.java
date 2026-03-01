
/*PROJECT - MYCONTACTAPP
@Author Harsheen
@Version 2.0 - Authentication Interface, implemented by Basic Authentication */

package com.seveneleven.mycontactsapp.auth;

import java.util.Optional;

import com.seveneleven.mycontactsapp.user.model.User;

public interface Authentication {
    Optional<String> login(String username, String password);
}

