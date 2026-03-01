package com.seveneleven.mycontactsapp.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactRepository {
    private final List<CreateContact> contacts = new ArrayList<>();

    // Only storage/retrieval responsibilities
    public void addContact(CreateContact contact) {
        contacts.add(contact);
    }

    public Optional<CreateContact> findById(String id) {
        return contacts.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Optional<CreateContact> findByName(String name) {
        return contacts.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst();
    }

    public List<CreateContact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    public boolean deleteContact(String id) {
        return contacts.removeIf(c -> c.getId().equals(id));
    }
}

