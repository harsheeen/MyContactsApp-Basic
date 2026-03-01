package com.seveneleven.mycontactsapp.user.proiles;

import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHasher;

import java.security.NoSuchAlgorithmException;

public class ProfileService {

    // Update profile info (name, email, etc.)
    public void updateProfile(User user, String newProfileInfo, String newEmail) {
        if (newProfileInfo != null && !newProfileInfo.isBlank()) {
            user.setProfileInfo(newProfileInfo);
        }
        if (newEmail != null && !newEmail.isBlank()) {
            user.setEmail(newEmail);
        }
    }

    // Change password securely
    public void changePassword(User user, String oldPassword, String newPassword) throws NoSuchAlgorithmException {
        String oldPasswordHash = PasswordHasher.hashPassword(oldPassword);

        if (user.getPasswordHash().equals(oldPasswordHash)) {
            String newPasswordHash = PasswordHasher.hashPassword(newPassword);
            user.setPasswordHash(newPasswordHash);
        } else {
            throw new SecurityException("Invalid old password");
        }
    }
}
