# MyContactsAppBasic

A simple Java application for managing contacts with authentication, contact operations such as crate, update, view, edit, and delete. This application also provides mtag management in later use cases. 
## Use Cases

### 1. User Registration
- Allows new users to register with the system.
- Stores basic profile information for future use.

### 2. Authentication
- Provides login functionality using `Authentication` and `BasicAuth`.
- Manages active sessions with `SessionManager`.

### 3. Create Contact
- Users can add new contacts with details like name, phone, and email.
- Saves contacts into the repository for later retrieval.

### 4. View Contact
- Displays contact details in a user-friendly format.
- Supports viewing individual or multiple contacts.

### 5. Delete Contact
- Removes a contact from the repository.
- Ensures data consistency after deletion.

### 6. Bulk Operations
- Perform actions (like add or delete) on multiple contacts at once.
- Useful for large-scale contact management.

### 7. Filter Contacts
- Search or filter contacts based on criteria (e.g., name, tag).
- Implemented via `FilterService`.

### 8. Tagging Contacts
- Add tags to contacts for better organization.
- Manage tags with `Tag` and `TagManager`.

### 9. User Profiles
- Manage user-specific information through `ProfileService`.
- Supports profile updates and retrieval.

### 10. Application Entry Point
- `Main.java` serves as the starting point of the application.
- Initializes services and runs the app.

---

## Notes
- `.gitignore` excludes build artifacts and IDE-specific files.
- Work is organized into feature branches (e.g., `feature/UserRegistration`, `feature/ContactEditor`).
- Commit only tracked files to avoid adding unintended new files.
