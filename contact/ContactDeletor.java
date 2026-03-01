


/* * Poject - MyContactApp
 * Version 7.0 User removes a contact from their list with confirmation.
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact;

public class ContactDeletor {

    // Delete by ID
    public static boolean deleteById(ContactRepository repo, String id) {
        return repo.deleteContact(id);
    }

    // Delete by Name
    public static boolean deleteByName(ContactRepository repo, String name) {
        return repo.findByName(name)
                   .map(contact -> repo.deleteContact(contact.getId()))
                   .orElse(false);
    }
}
