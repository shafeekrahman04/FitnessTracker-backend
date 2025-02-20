package com.example.fitnessTracker.utils.enumConstant;

public enum Gender {
    MALE("M", "Male"),
    FEMALE("F", "Female");

    private String value;
    private String display;

    Gender(String value, String display) {
        this.value = value;
        this.display = display;
    }

    public String getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }

    public static Gender valueMatch(String value) {

        for (Gender gender : Gender.values()) {
            if (gender.getValue().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        return MALE;
    }

}
