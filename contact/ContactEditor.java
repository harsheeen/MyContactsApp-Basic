

/* * Poject - MyContactApp
 * Version 6.0  User modifies existing contact information.
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact;

public class ContactEditor {
    public static void editName(CreateContact contact, String newName) {
        contact.setName(newName);
    }

    public static void addPhone(CreateContact contact, String phone) {
        contact.addPhoneNumber(phone);
    }

    public static void addEmail(CreateContact contact, String email) {
        contact.addEmail(email);
    }
}
