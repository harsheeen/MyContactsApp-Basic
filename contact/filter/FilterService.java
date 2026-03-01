/* * Poject - MyContactApp
 * Version 10.0 User applies multiple filters (by tag, date added, frequently contacted).
 * User views complete information of a specific contact.
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.contact.filter;

import com.seveneleven.mycontactsapp.contact.CreateContact;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterService {

    // Filter by tag
    public static List<CreateContact> filterByTag(List<CreateContact> contacts, String tag) {
        return contacts.stream()
                .filter(c -> c.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    // Filter by date added (sort oldest/newest)
    public static List<CreateContact> sortByDate(List<CreateContact> contacts, boolean newestFirst) {
        return contacts.stream()
                .sorted(newestFirst ?
                        Comparator.comparing(CreateContact::getCreatedAt).reversed() :
                        Comparator.comparing(CreateContact::getCreatedAt))
                .collect(Collectors.toList());
    }

    // Filter by frequently contacted (example: by number of phone numbers/emails)
    public static List<CreateContact> filterFrequent(List<CreateContact> contacts) {
        return contacts.stream()
                .filter(c -> c.getPhoneNumbers().size() > 1 || c.getEmails().size() > 1)
                .collect(Collectors.toList());
    }
}
