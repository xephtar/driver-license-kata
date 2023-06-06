package org.example;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private String label;


    Gender(String f) {
        label = f;
    }

    public String getLabel() {
        return label;
    }
}
