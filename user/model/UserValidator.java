/* * Poject - MyContactApp
 * Version 1.0 The user is validates with Regex Pattern
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */
package com.seveneleven.mycontactsapp.user.model;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean validateProfileInfo(String profileInfo) {
        return profileInfo != null && !profileInfo.trim().isEmpty();
    }
}
