package com.opencart.managers;

public class DataSubstituteManager {
    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOM":
                return RandomDataGenerator.generateLastName();
            case "RANDOMEMAIL":
                return RandomDataGenerator.generateRandomEmail();
            case "RANDOMFIRSTNAME":
                return RandomDataGenerator.generateFirstName();
            case "RANDOMPASSWORD":
                return RandomDataGenerator.generatePassword();
        }
        return value;
    }
}
