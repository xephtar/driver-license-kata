package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderTest {
    @Test
    void shouldFemaleBeF() {
        assertEquals("F", Gender.FEMALE.getLabel());
    }

    @Test
    void shouldMaleBeF() {
        assertEquals("M", Gender.MALE.getLabel());
    }
}