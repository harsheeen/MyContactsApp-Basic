/* * Poject - MyContactApp
 * Version 11.0 User creates custom tags (Family, Work, Friends) for organizing contacts.
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact.tags;

import com.seveneleven.mycontactsapp.contact.CreateContact;

public class TagManager {

    // Assign a tag
    public static void addTag(CreateContact contact, Tag tag) {
        contact.getTags().add(tag.getName());
    }

    // Remove a tag
    public static void removeTag(CreateContact contact, Tag tag) {
        contact.getTags().remove(tag.getName());
    }
}
