
/* * Poject - MyContactApp
 * Version 5.0 View Contact Details
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact;

public class ContactViewer {
    public static void viewContact(CreateContact contact) {
        System.out.println("=== Contact Details ===");
        System.out.println(contact.toString());
    }
}
