package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DriverLicenseTest {

    private static Stream<Arguments> provideStringsForSurname() {
        return Stream.of(Arguments.of("Smith", "SMITH"),
                Arguments.of("Joy", "JOY99"),
                Arguments.of("", "99999"),
                Arguments.of("Davarci", "DAVAR"),
                Arguments.of(null, "99999"));
    }

    private static Stream<Arguments> provideStringsForFirstAndMiddleName() {
        return Stream.of(Arguments.of("Smith", "Joanna", "SJ"),
                Arguments.of("Ufuk", "", "U9"));
    }

    private static Stream<Arguments> provideInputsForDriverLicense() {
        return Stream.of(
                Arguments.of(List.of("John", "Smith", "01-Jan-2000", "M"),""),
                Arguments.of(List.of("John", "James", "Smith", "01-Jan-2000", "M"),"SMITH001010JJ9AA"),
                Arguments.of(List.of("John", "", "Smith", "01-Jan-2000", "M"),"SMITH001010J99AA"),
                Arguments.of(List.of("Johanna", "", "Gibbs", "13-Dec-1981", "F"),"GIBBS862131J99AA"),
                Arguments.of(List.of("Johanna", "Olive", "Gibbs", "13-Dec-1981", "F"),"GIBBS862131JO9AA"));
    }

    DriverLicense driverLicense;

    @BeforeEach
    void setUp() {
        driverLicense = new DriverLicense();
    }

    @ParameterizedTest
    @MethodSource("provideStringsForSurname")
    void shouldFormatTakeFiveCharactersFromSurname(String surname, String expectedSurname) {
        String formattedSurname = driverLicense.formatSurname(surname);
        assertEquals(expectedSurname, formattedSurname);
    }

    @Test
    void shouldFormatSurnameWithNinePaddingIfItIsLessThanFiveCharacters() {
        String formattedSurname = driverLicense.formatSurname("Joy");
        assertEquals("JOY99", formattedSurname);
    }

    @Test
    void shouldFormatDecadeFromBirthYear() {
        String formatBirthYear = driverLicense.formatDecadeFromBirthYear("2011");
        assertEquals("1", formatBirthYear);
    }

    @Test
    void shouldFormatMonthFromBirthDateForMale() {
        String formatBirthYear = driverLicense.formatMonthFromBirthYear("12", Gender.MALE.getLabel());
        assertEquals("12", formatBirthYear);
    }

    @Test
    void shouldFormatMonthFromBirthDateForFemale() {
        String formatBirthYear = driverLicense.formatMonthFromBirthYear("12", Gender.FEMALE.getLabel());
        assertEquals("62", formatBirthYear);
    }

    @Test
    void shouldFormatTheYearDigitFromBirthDate() {
        String expectedYear = driverLicense.formatYearDigitFromBirthDate("1983");
        assertEquals("3", expectedYear);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForFirstAndMiddleName")
    void shouldFormatFirstAndMiddleName(String firstName, String middleName, String expected) {
        String actual = driverLicense.formatFirstAndMiddleName(firstName, middleName);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideInputsForDriverLicense")
    void shouldGetDriverLicenseNumber(List<String> inputs, String expected) {
        String actualDriverLicenseNumber = driverLicense.generate(inputs);
        assertEquals(expected, actualDriverLicenseNumber);
    }
}