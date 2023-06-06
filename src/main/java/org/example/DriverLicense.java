package org.example;

import java.util.List;

public class DriverLicense {
    private final Integer MIN_INPUT_LIMIT = 5;
    private final String ARBITRARY_DIGITS = "9AA";
    private final String BASE_SURNAME = "99999";
    private final String BASE_INITIALS = "99";

    public String formatSurname(String surname) {
        if(surname == null){
            return BASE_SURNAME;
        }

        return surname.toUpperCase().concat(BASE_SURNAME).substring(0, 5);
    }

    public String formatDecadeFromBirthYear(String birthYear) {
        return birthYear.substring(2,3);
    }

    public String formatMonthFromBirthYear(String month, String gender) {
        if(Gender.FEMALE.getLabel().equals(gender)){
            return String.valueOf(Integer.parseInt(month) + 50);
        }

        return month;
    }

    public String formatYearDigitFromBirthDate(String year) {
        return year.substring(year.length()-1);
    }

    public String formatFirstAndMiddleName(String firstName, String middleName) {
        StringBuilder output = new StringBuilder();
        output.append(firstName.toUpperCase().charAt(0));

        if (middleName.length() > 1){
            output.append(middleName.toUpperCase().charAt(0));
        }

        return output.toString().concat(BASE_INITIALS).substring(0,2);
    }

    public String generate(List<String> inputs) {
        if(inputs.size() < MIN_INPUT_LIMIT){
            return "";
        }
        DriverAttributes attributes = new DriverAttributes(inputs);

        StringBuilder output = new StringBuilder();
        output.append(formatSurname(attributes.getSurname()));
        output.append(formatDecadeFromBirthYear(attributes.getBirthYear()));
        output.append(formatMonthFromBirthYear(attributes.getBirthMonth(), attributes.getGender()));
        output.append(attributes.getBirthDay());
        output.append(formatYearDigitFromBirthDate(attributes.getBirthYear()));
        output.append(formatFirstAndMiddleName(attributes.getFirstName(), attributes.getMiddleName()));
        return output.toString().concat(ARBITRARY_DIGITS);
    }
}
