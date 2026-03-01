package com.seveneleven.mycontactsapp.user.model;

public class User {
    private String email;
    private String passwordHash;
    private String profileInfo;

    public User(String email, String passwordHash, String profileInfo) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.profileInfo = profileInfo;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
		this.email = email;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPasswordHash() {
        return passwordHash;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    // Setters (optional, depending on immutability preference)
    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }
}
