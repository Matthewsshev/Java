package org.example.model;

public enum Sex {
    MALE("Чоловіча"),
    FEMALE("Жіноча");

    private final String displayName;

    Sex(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}