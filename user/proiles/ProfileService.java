package com.seveneleven.mycontactsapp.user.proiles;

import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHasher;

public class ProfileService {
    public void updateProfile(User user, String newName, String newEmail) {
        user.setUsername(newName);
        user.setEmail(newEmail);
    }

    public void changePassword(User user, String oldPassword, String newPassword) {
        if(user.getPassword().equals(PasswordHasher.hash(oldPassword))) {
            user.setPassword(newPassword);
        } else {
            throw new SecurityException("Invalid old password");
        }
    }
}

