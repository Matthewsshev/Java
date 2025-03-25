package ntudp.lab3.model;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private final String displayName;

    Sex(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}