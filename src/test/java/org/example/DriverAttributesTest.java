package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverAttributesTest {

    @Test
    void shouldGetAttributesFromStringInputs() {
        var inputs = List.of("John", "James", "Smith", "01-Jan-2000", "M");
        DriverAttributes attributes = new DriverAttributes(inputs);

        assertEquals("John",attributes.getFirstName());
        assertEquals("James",attributes.getMiddleName());
        assertEquals("Smith",attributes.getSurname());
        assertEquals("01",attributes.getBirthDay());
        assertEquals("01",attributes.getBirthMonth());
        assertEquals("2000",attributes.getBirthYear());
        assertEquals("M",attributes.getGender());
    }
}