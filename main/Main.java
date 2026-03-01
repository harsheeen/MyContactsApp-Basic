/* 
 * * Poject - MyContactApp
 * Main Function - Includes all use cases 
 * @Author Harsheen Kaur
 * 
 */

package com.seveneleven.mycontactsapp.main;

import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.model.UserValidator;
import com.seveneleven.mycontactsapp.user.validation.PasswordValidator;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHasher;
import com.seveneleven.mycontactsapp.auth.Authentication;
import com.seveneleven.mycontactsapp.auth.BasicAuth;
import com.seveneleven.mycontactsapp.auth.SessionManager;
import com.seveneleven.mycontactsapp.user.proiles.ProfileService;
import com.seveneleven.mycontactsapp.contact.*;
import com.seveneleven.mycontactsapp.contact.filter.FilterService;
import com.seveneleven.mycontactsapp.contact.tags.Tag;
import com.seveneleven.mycontactsapp.contact.tags.TagManager;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactRepository repo = new ContactRepository();

        try {
            System.out.println("Are you a new user? (yes/no): ");
            String choice = scanner.nextLine();

            User currentUser = null;

            if (choice.equalsIgnoreCase("yes")) {
                // Registration
                System.out.println("=== User Registration ===");
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                if (!UserValidator.validateEmail(email)) throw new IllegalArgumentException("Invalid email format.");

                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (!PasswordValidator.validatePassword(password)) throw new IllegalArgumentException("Weak password.");

                System.out.print("Enter profile info: ");
                String profileInfo = scanner.nextLine();
                if (!UserValidator.validateProfileInfo(profileInfo)) throw new IllegalArgumentException("Profile info cannot be empty.");

                String hashedPassword = PasswordHasher.hashPassword(password);
                currentUser = new User(email, hashedPassword, profileInfo);
                System.out.println("User registered successfully!");
            }

            // Login
            System.out.println("\n=== User Login ===");
            System.out.print("Enter email: ");
            String loginEmail = scanner.nextLine();
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            Authentication auth = new BasicAuth(currentUser);
            SessionManager sessionManager = new SessionManager();

            Optional<String> loginResult = auth.login(loginEmail, loginPassword);

            if (loginResult.isPresent()) {
                System.out.println(loginResult.get());
                String sessionId = sessionManager.createSession(loginEmail);
                System.out.println("Session created with ID: " + sessionId);

                if (sessionManager.validateSession(sessionId)) {
                    boolean running = true;
                    while (running) {
                        System.out.println("\nChoose an option:");
                        System.out.println("1. Update Profile (UC-03)");
                        System.out.println("2. Create Contact (UC-04)");
                        System.out.println("3. View All Contacts (UC-05)");
                        System.out.println("4. Edit Contact (UC-06)");
                        System.out.println("5. Delete Contact (UC-07)");
                        System.out.println("6. Bulk Operations (UC-08)");
                        System.out.println("7. Search Contacts (UC-09)");
                        System.out.println("8. Filter Contacts (UC-10)");
                        System.out.println("9. Create Tag (UC-11)");
                        System.out.println("10. Apply Tag to Contact (UC-12)");
                        System.out.println("11. Logout");

                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                ProfileService profileService = new ProfileService();
                                System.out.print("Enter new profile info: ");
                                String newProfileInfo = scanner.nextLine();
                                System.out.print("Enter new email: ");
                                String newEmail = scanner.nextLine();
                                profileService.updateProfile(currentUser, newProfileInfo, newEmail);
                                System.out.println("Profile updated: " + currentUser.getEmail());
                                break;

                            case "2":
                                System.out.print("Enter contact name: ");
                                String contactName = scanner.nextLine();
                                CreateContact contact = new CreateContact(contactName);
                                System.out.print("Enter phone: ");
                                String phone = scanner.nextLine();
                                if (!phone.isBlank()) contact.addPhoneNumber(phone);
                                System.out.print("Enter email: ");
                                String email = scanner.nextLine();
                                if (!email.isBlank()) contact.addEmail(email);
                                repo.addContact(contact);
                                System.out.println("Contact created!");
                                break;

                            case "3":
                                repo.getAllContacts().forEach(ContactViewer::viewContact);
                                break;

                            case "4":
                                System.out.print("Enter contact name to edit: ");
                                String editName = scanner.nextLine();
                                repo.findByName(editName).ifPresentOrElse(c -> {
                                    System.out.print("Enter new name: ");
                                    String newName = scanner.nextLine();
                                    if (!newName.isBlank()) ContactEditor.editName(c, newName);
                                    System.out.print("Add phone: ");
                                    String newPhone = scanner.nextLine();
                                    if (!newPhone.isBlank()) ContactEditor.addPhone(c, newPhone);
                                    System.out.print("Add email: ");
                                    String newEmailContact = scanner.nextLine();
                                    if (!newEmailContact.isBlank()) ContactEditor.addEmail(c, newEmailContact);
                                    System.out.println("Contact updated!");
                                }, () -> System.out.println("Contact not found."));
                                break;

                            case "5":
                                System.out.print("Enter contact name to delete: ");
                                String delName = scanner.nextLine();
                                boolean deleted = repo.findByName(delName)
                                        .map(c -> repo.deleteContact(c.getId()))
                                        .orElse(false);
                                System.out.println(deleted ? "Deleted successfully." : "Contact not found.");
                                break;

                            case "6":
                                System.out.println("Bulk delete all contacts? (yes/no): ");
                                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                                    for (CreateContact c : repo.getAllContacts()) {
                                        repo.deleteContact(c.getId());
                                    }
                                    System.out.println("All contacts deleted.");
                                }
                                break;

                            case "7":
                                System.out.println("Search by name: ");
                                
                                switch ("name") {
                                    case "name":
                                        repo.findByName("name").ifPresentOrElse(ContactViewer::viewContact,
                                                () -> System.out.println("No match found."));
                                        break;
                                    
                                    default:
                                        System.out.println("Invalid search type.");
                                }
                                break;

                            case "8":
                                System.out.println("Filter by (tag/date/frequent): ");
                                String filterType = scanner.nextLine();
                                switch (filterType.toLowerCase()) {
                                    case "tag":
                                        System.out.print("Enter tag: ");
                                        String tag = scanner.nextLine();
                                        FilterService.filterByTag(repo.getAllContacts(), tag)
                                                .forEach(ContactViewer::viewContact);
                                        break;
                                    case "date":
                                        System.out.println("Newest first? (yes/no): ");
                                        boolean newestFirst = scanner.nextLine().equalsIgnoreCase("yes");
                                        FilterService.sortByDate(repo.getAllContacts(), newestFirst)
                                                .forEach(ContactViewer::viewContact);
                                        break;
                                    case "frequent":
                                        FilterService.filterFrequent(repo.getAllContacts())
                                                .forEach(ContactViewer::viewContact);
                                        break;
                                    default:
                                        System.out.println("Invalid filter type.");
                                }
                                break;

                            case "9":
                                System.out.print("Enter new tag name: ");
                                String tagName = scanner.nextLine();
                                Tag newTag = new Tag(tagName);
                                System.out.println("Tag created: " + newTag);
                                break;

                            case "10":
                                System.out.print("Enter contact name to tag: ");
                                String contactToTag = scanner.nextLine();
                                System.out.print("Enter tag name: ");
                                String tagToApply = scanner.nextLine();
                                Tag tagObj = new Tag(tagToApply);
                                repo.findByName(contactToTag).ifPresentOrElse(c -> {
                                    TagManager.addTag(c, tagObj);
                                    System.out.println("Tag applied. Current tags: " + c.getTags());
                                }, () -> System.out.println("Contact not found."));
                                break;

                            case "11":
                                sessionManager.endSession(sessionId);
                                System.out.println("Logged out. Session ended.");
                                running = false;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                }
            } else {
                System.out.println("Login failed.");
            }

        } catch (IllegalArgumentException | NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
