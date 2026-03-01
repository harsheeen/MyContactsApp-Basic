/* * Poject - MyContactApp
 * Version 2.0 The password is hashed using messge digest 
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */
package com.seveneleven.mycontactsapp.user.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // md is object of type MessageDigest
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
