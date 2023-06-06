package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DriverAttributes {
    private String firstName;
    private String middleName;
    private String surname;
    private String gender;
    private String birthYear;
    private String birthDay;
    private String birthMonth;

    public DriverAttributes(List<String> inputs) {
        firstName = inputs.get(0);
        middleName = inputs.get(1);
        surname = inputs.get(2);
        gender = inputs.get(4);

        var birthDate = getFormattedDate(inputs.get(3));
        String DATE_DELIMITER = "-";
        birthDay = birthDate.split(DATE_DELIMITER)[0];
        birthMonth = birthDate.split(DATE_DELIMITER)[1];
        birthYear = birthDate.split(DATE_DELIMITER)[2];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    private String getFormattedDate(String input){
        String formattedDate = "";
        DateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = inputFormat.parse(input);
            formattedDate = outputFormat.format(date);
        } catch (Exception ignored){

        }

        return formattedDate;
    }
}
