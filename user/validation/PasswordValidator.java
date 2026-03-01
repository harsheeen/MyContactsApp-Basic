/* * Poject - MyContactApp
 * Version 1.0 The password is validates with Regex Pattern
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */
package com.seveneleven.mycontactsapp.user.validation;

public class PasswordValidator {

    public static boolean validatePassword(String password) {
        // Example: at least 8 chars, one uppercase, one lowercase, one digit
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false, hasLower = false, hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUpper && hasLower && hasDigit;
    }
}
