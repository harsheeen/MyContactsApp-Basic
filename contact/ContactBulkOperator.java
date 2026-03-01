/* * Poject - MyContactApp
 * Version 8.0 User performs operations on multiple contacts (delete, tag, export).
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ContactBulkOperator {

    // Bulk delete by IDs
    public static void bulkDelete(ContactRepository repo, Set<String> ids) {
        for (String id : ids) {
            repo.deleteContact(id);
        }
    }

    // Bulk tag contacts
    public static void bulkTag(List<CreateContact> contacts, String tag) {
        for (CreateContact contact : contacts) {
            contact.addEmail(tag + "@tagged"); // Example: tagging via email suffix
        }
    }

    // Bulk export to file
    public static void exportContacts(List<CreateContact> contacts, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (CreateContact contact : contacts) {
                writer.write(contact.toString() + "\n");
            }
            System.out.println("Contacts exported to " + filePath);
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }
}
