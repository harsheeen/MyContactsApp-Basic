/* * Poject - MyContactApp
 * Version 9.0 User searches contacts by name, phone, email, or tags.
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact;

import java.util.List;
import java.util.stream.Collectors;
public class ContactSearcher {
    // Search by name
    public static List<CreateContact> searchByName(List<CreateContact> contacts, String name) {
        return contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name) || c.getName().contains(name))
                .collect(Collectors.toList());
    }
    

    // Search by tag (example: email suffix used as tag)
    public static List<CreateContact> searchByTag(List<CreateContact> contacts, String tag) {
        return contacts.stream()
                .filter(c -> c.getEmails().stream().anyMatch(e -> e.contains(tag)))
                .collect(Collectors.toList());
    }
}
