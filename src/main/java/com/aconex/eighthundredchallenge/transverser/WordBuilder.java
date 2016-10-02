package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.EightHundredBitMap;
import com.aconex.eighthundredchallenge.mapper.Mapper;

/**
 * Created by aaron.spiteri on 27/09/2016.
 */
public class WordBuilder {
    private StringBuilder sb = new StringBuilder();
    private String digitString;
    private Mapper mapper;
    private static final char BOUNDRY = '-';

    public int getCurrentPos() {
        return (sb.length() > 0) ? sb.toString().replace("" + BOUNDRY, "").length() : 0;
    }

    public WordBuilder(String digitString, Mapper mapper) {
        this.digitString = digitString;
        this.mapper = mapper;
    }

    public WordBuilder(String digitString, Mapper mapper, String word) {
        this.digitString = digitString;
        this.mapper = mapper;
        sb.append(word);
    }

    public boolean appendForce(EightHundredBitMap cbm) {
        sb.append(cbm.getKey());
        return true;
    }

    public boolean append(EightHundredBitMap cbm) {
        if (isMatch(cbm)) {
            sb.append(cbm.getKey());
            return true;
        }
        return false;
    }

    public EightHundredBitMap currentDigit() {
        return (EightHundredBitMap) mapper.getCharacterBitmap(digitString.charAt(getCurrentPos()));
    }

    public boolean isMatch(EightHundredBitMap cbm) {
        if (getCurrentPos() >= digitString.length()) {
            return false;
        }

        return ((cbm.getBitMask() & currentDigit().getBitMask()) > 0);
    }

    public String getWord() {
        return sb.toString();
    }

    public void setBoundry() {
        sb.append(BOUNDRY);
    }

    public boolean isSlotsFilled() {
        return (getCurrentPos() >= digitString.length());
    }

    public boolean isLastChar(char c) {
        if (sb.length() == 0) {
            return false;
        }
        return (getLastChar() == c);
    }

    public char getLastChar() {
        char c = '\u0000';
        if (sb.length() < 1) {
            return c;
        }

        return sb.charAt(sb.length() - 1);
    }

    public boolean isBoundrySet() {
        return isLastChar(BOUNDRY);
    }

    public Mapper getMapper() {
        return mapper;
    }

    public String getDigitString() {
        return digitString;
    }

    public void removeLastBoundry() {
        sb.deleteCharAt(sb.length() - 1);
    }

}
