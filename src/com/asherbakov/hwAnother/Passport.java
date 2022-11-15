package com.asherbakov.hwAnother;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {
    private String number;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate dateOfBirthday;

    public Passport(String number, String lastName, String firstName, String middleName, LocalDate dateOfBirthday) {
        if (number != null && !number.isBlank() && checkNumber(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Номер паспорта должен иметь вид: ХХ ХХ ХХХХХХ.");
        }
        if (lastName != null && !lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Введите фамилию.");
        }
        if (firstName != null && !firstName.isBlank()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Введите имя.");
        }
        if (middleName != null) {
            this.middleName = middleName;
        } else {
            this.middleName = "";
        }
        if (dateOfBirthday != null) {
            this.dateOfBirthday = dateOfBirthday;
        } else {
            throw new IllegalArgumentException("Введите дату рождения.");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    private boolean checkNumber(String number) {
        Pattern pattern = Pattern.compile("\\d{2}\\s\\d{2}\\s\\d{6}");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return number.equals(passport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number='" + number + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                '}';
    }
}
