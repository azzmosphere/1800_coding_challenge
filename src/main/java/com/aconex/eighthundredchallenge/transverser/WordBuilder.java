package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.EightHundredBitMap;
import com.aconex.eighthundredchallenge.mapper.Mapper;

/**
 * Created by aaron.spiteri on 27/09/2016.
 */
public class WordBuilder {
    private int currentPos;
    private StringBuilder sb = new StringBuilder();
    private String digitString;
    private Mapper mapper;
    private static final char BOUNDRY = '-';

    public WordBuilder(String digitString, Mapper mapper) {
        this.digitString = digitString;
        this.mapper = mapper;
    }

    public WordBuilder(String digitString, Mapper mapper, String word) {
        this.digitString = digitString;
        this.mapper = mapper;
        sb.append(word);
        currentPos = word.length() - 1;
    }

    public boolean append(EightHundredBitMap cbm) {
        if (isMatch(cbm)) {
            sb.append(cbm.getKey());
            currentPos++;

            return true;
        }
        return false;
    }

    public boolean isMatch(EightHundredBitMap cbm) {
        if (currentPos >= digitString.length()) {
            return false;
        }

        EightHundredBitMap bm = (EightHundredBitMap) mapper.getCharacterBitmap(digitString.charAt(currentPos));
        return ((cbm.getBitMask() & bm.getBitMask()) > 0);
    }

    public String getWord() {
        return sb.toString();
    }

    public void setBoundry() {
        sb.append(BOUNDRY);
    }

    public boolean isSlotsFilled() {
        return (currentPos >= digitString.length());
    }

    public boolean isBoundrySet() {
        if (sb.length() == 0) {
            return false;
        }
        return (sb.charAt(sb.length() - 1) == BOUNDRY);
    }

    public Mapper getMapper() {
        return mapper;
    }

    public String getDigitString() {
        return digitString;
    }

}
