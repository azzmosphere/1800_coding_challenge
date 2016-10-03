package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.EightHundredBitMap;
import com.aconex.eighthundredchallenge.mapper.Mapper;

/**
 * Responsible for mapping digit characters to alpha characters at a bit level.
 *
 * Created by aaron.spiteri on 27/09/2016.
 */
public class WordBuilder {
    private StringBuilder sb = new StringBuilder();
    private String digitString;
    private Mapper mapper;
    private static final char BOUNDRY = '-';

    /**
     * Current position of digit string.
     *
     * @return current position
     */
    public int getCurrentPos() {
        return (sb.length() > 0) ? sb.toString().replace("" + BOUNDRY, "").length() : 0;
    }

    /**
     * class constructor.
     *
     * @param digitString
     * @param mapper
     */
    public WordBuilder(String digitString, Mapper mapper) {
        this.digitString = digitString;
        this.mapper = mapper;
    }

    /**
     * class constructor.
     *
     * @param digitString
     * @param mapper
     * @param word
     */
    public WordBuilder(String digitString, Mapper mapper, String word) {
        this.digitString = digitString;
        this.mapper = mapper;
        sb.append(word);
    }

    /**
     * for cbm to be appended to the found word output regardless of whether it can be mapped.
     *
     * @param cbm
     * @return always true.
     */
    public boolean appendForce(EightHundredBitMap cbm) {
        sb.append(cbm.getKey());
        return true;
    }

    /**
     * compares the character representation (alpha) to the numeric represention of phone number digit at
     * current position. If true then appends the cbm to the result.  Returns the output of isMatch()
     *
     * @param cbm
     * @return true on success, false on failure.
     */
    public boolean append(EightHundredBitMap cbm) {
        if (isMatch(cbm)) {
            sb.append(cbm.getKey());
            return true;
        }
        return false;
    }

    /**
     * returns the digit character that is to be evaluated.
     *
     * @return digit character
     */
    public EightHundredBitMap currentDigit() {
        return (EightHundredBitMap) mapper.getCharacterBitmap(digitString.charAt(getCurrentPos()));
    }

    /**
     * compares a character bitmap to a digit bitmap and returns true if there is a match.
     *
     * @param cbm
     * @return true on success
     */
    public boolean isMatch(EightHundredBitMap cbm) {
        if (getCurrentPos() >= digitString.length()) {
            return false;
        }

        return ((cbm.getBitMask() & currentDigit().getBitMask()) > 0);
    }

    /**
     * Returns the word that has been created.
     *
     * @return word
     */
    public String getWord() {
        return sb.toString();
    }

    /**
     * sets a word boundry
     */
    public void setBoundry() {
        sb.append(BOUNDRY);
    }

    /**
     * checks if more characters can be added to the word.
     *
     * @return true if characters can be added.
     */
    public boolean isSlotsFilled() {
        return (getCurrentPos() >= digitString.length());
    }

    /**
     * evaluates if the last character in the word is equal to c
     *
     * @param c
     * @return true on match.
     */
    public boolean isLastChar(char c) {
        if (sb.length() == 0) {
            return false;
        }
        return (getLastChar() == c);
    }

    /**
     * returns the last character of the word.
     *
     * @return last character or NULL
     */
    public char getLastChar() {
        char c = '\u0000';
        if (sb.length() < 1) {
            return c;
        }

        return sb.charAt(sb.length() - 1);
    }

    /**
     * checks to see if the last character was a word boundry.
     *
     * @return true on match
     */
    public boolean isBoundrySet() {
        return isLastChar(BOUNDRY);
    }

    /**
     * returns the digit mapper, or what ever is set as the mapper.
     *
     * @return mapper
     */
    public Mapper getMapper() {
        return mapper;
    }

    /**
     * Returns the character reprentation of the number string.
     *
     * @return digit string
     */
    public String getDigitString() {
        return digitString;
    }

    /**
     * removes the last character in the word.
     */
    public void removeLastBoundry() {
        sb.deleteCharAt(sb.length() - 1);
    }

}
