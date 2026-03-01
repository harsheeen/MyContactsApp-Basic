 /* * Poject - MyContactApp
 * Version 4.0 - Create Contact 
 * User adds a new contact with name, phone numbers, email addresses, and optional fields. 
 * @Author Harsheen Kaur
 * 
 */


package com.seveneleven.mycontactsapp.contact;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CreateContact {
    private final String id;
    private final LocalDateTime createdAt;
    private String name;
    private List<String> phoneNumbers;
    private List<String> emails;

    public CreateContact(String name) {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<String> getPhoneNumbers() { return new ArrayList<>(phoneNumbers); }
    public List<String> getEmails() { return new ArrayList<>(emails); }

    // Add methods
    public void addPhoneNumber(String phone) {
        if (phone != null && !phone.isBlank()) phoneNumbers.add(phone);
    }

    public void addEmail(String email) {
        if (email != null && !email.isBlank()) emails.add(email);
    }

    // Edit methods
    public void setName(String newName) {
        if (newName != null && !newName.isBlank()) this.name = newName;
    }

    @Override
    public String toString() {
        return String.format("Contact[%s]\nName: %s\nPhones: %s\nEmails: %s\nCreated: %s",
                id, name, phoneNumbers, emails, createdAt);
    }
    private Set<String> tags = new HashSet<>();

    public Set<String> getTags() { return tags; }

}
