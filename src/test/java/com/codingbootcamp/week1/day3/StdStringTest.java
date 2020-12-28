package com.codingbootcamp.week1.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StdStringTest {

    @Test
    void toAsciiLowerCase() {
        var testStr = new StdString(new char[]{'H', 'e', 'L', 'L', 'o'});

        assertEquals("hello", testStr.toAsciiLowerCase().toString());
        assertEquals("HeLLo", testStr.toString());
    }

    @Test
    void toAsciiLowerCaseWithLegalNonAlphabetCharacters() {
        var testStr = new StdString(new char[]{'H', 'e', 'L', 'L', 'o', '1', ' '});

        assertEquals("hello1 ", testStr.toAsciiLowerCase().toString());
        assertEquals("HeLLo1 ", testStr.toString());
    }

    @Test
    void toAsciiLowerCaseWithIllegalCharacters() {
        var testStr = new StdString(new char[]{(char)299, 'e', 'L', 'L', 'o', '1', ' '});

        try {
            testStr.toAsciiLowerCase();
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void toAsciiUpperCase() {
        var testStr = new StdString(new char[]{'H', 'e', 'L', 'L', 'o'});

        assertEquals("HELLO", testStr.toAsciiUpperCase().toString());
        assertEquals("HeLLo", testStr.toString());
    }

    @Test
    void toAsciiUpperCaseWithLegalNonAlphabetCharacters() {
        var testStr = new StdString(new char[]{' ', '!', 'H', 'e', 'L', 'L', 'o'});

        assertEquals(" !HELLO", testStr.toAsciiUpperCase().toString());
    }

    @Test
    void toAsciiUpperCaseWithIllegalCharacters() {
        var testStr = new StdString(new char[]{(char)299, '!', 'H', 'e', 'L', 'L', 'o'});

        try {
            testStr.toAsciiUpperCase();
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void subString() {
        var testStr = new StdString(new char[]{'H', 'e', 'L', 'L', 'o', '1', '2', '3'});

        assertEquals("eLLo1", testStr.subString(1, 6).toString());
        assertEquals("LL", testStr.subString(2, 4).toString());
    }

    @Test
    void subStringWithIncorrectIndex() {
        var testStr = new StdString(new char[]{'H', 'e', 'L', 'L', 'o', '1', '2', '3'});

        try {
            testStr.subString(-1, 6);
            fail();
        } catch (IndexOutOfBoundsException e) {

        }
    }

    @Test
    void subStringWithFromBiggerThanTo() {
        var testStr = new StdString(new char[]{'H', 'e', 'L', 'L', 'o', '1', '2', '3'});

        try {
            testStr.subString(7, 6);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void concat() {
        var testStrLeft = new StdString(new char[]{'H', 'e', 'L', 'L', 'o'});
        var testStrRight = new StdString(new char[]{'1', '2', '3'});
        assertEquals("HeLLo123", testStrLeft.concat(testStrRight).toString());
        assertEquals("HeLLo", testStrLeft.toString());
        assertEquals("123", testStrRight.toString());
    }

    @Test
    void concatWithEmpty() {
        var testStrLeft = new StdString(new char[]{'H', 'e', 'L', 'L', 'o'});
        var testStrRight = new StdString(new char[]{});
        assertEquals("HeLLo", testStrLeft.concat(testStrRight).toString());
    }

    @Test
    void concatWithNullStr() {
        var testStrLeft = new StdString(new char[]{'H', 'e', 'L', 'L', 'o'});
        var testStrRight = (StdString)null;

        try {
            testStrLeft.concat(testStrRight);
            fail();
        } catch (NullPointerException e) {

        }
    }

    @Test
    void split() {
        var testStrLeft = new StdString(new char[]{
                ' ', ' ', 'H', 'e', 'L', 'L', 'o', ' ', '1', '2', '3', ' ', 'a', 'b', ' '});

        var actualResult = testStrLeft.split(' ');
        assertEquals(5, actualResult.length);
        assertEquals("", actualResult[0].toString());
        assertEquals("", actualResult[1].toString());
        assertEquals("HeLLo", actualResult[2].toString());
        assertEquals("123", actualResult[3].toString());
        assertEquals("ab", actualResult[4].toString());
        assertEquals("  HeLLo 123 ab ", testStrLeft.toString());
    }

    @Test
    void splitWithNonExistingSeparator() {
        var testStrLeft = new StdString(new char[]{
                ' ', ' ', 'H', 'e', 'L', 'L', 'o', ' ', '1', '2', '3', ' ', 'a', 'b', ' '});

        var actualResult = testStrLeft.split('!');
        assertEquals(1, actualResult.length);
        assertEquals("  HeLLo 123 ab ", actualResult[0].toString());
    }

    @Test
    void trim() {
        var testStrLeft = new StdString(new char[]{
                ' ', ' ', 'H', 'e', 'L', 'L', 'o', ' ', '1', '2', '3', ' ', 'a', 'b', ' '});

        var actualResult = testStrLeft.trim();
        assertEquals("HeLLo 123 ab", actualResult.toString());
        assertEquals("  HeLLo 123 ab ", testStrLeft.toString());
    }

    @Test
    void trimWithEmptyString() {
        var testStrLeft = new StdString();

        var actualResult = testStrLeft.trim();
        assertEquals("", actualResult.toString());
    }

    @Test
    void trimWithoutSpaces() {
        var testStrLeft = new StdString(new char[] {'1', '2', '3'});

        var actualResult = testStrLeft.trim();
        assertEquals("123", actualResult.toString());
    }

    @Test
    void removeCharacter() {
        var testStrLeft = new StdString(new char[]{
                ' ', ' ', 'H', 'e', 'L', 'L', 'o', ' ', '1', '2', '3', ' ', 'a', 'b', ' '});

        var actualResult = testStrLeft.removeCharacter(' ');
        assertEquals("HeLLo123ab", actualResult.toString());
        assertEquals("  HeLLo 123 ab ", testStrLeft.toString());
    }

    @Test
    void removeCharacterWithEmptyString() {
        var testStrLeft = new StdString();

        var actualResult = testStrLeft.removeCharacter(' ');
        assertEquals("", actualResult.toString());
    }
}