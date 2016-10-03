package com.aconex.eighthundredchallenge.mapper;

/**
 * creates a mapping of digit charcters.
 *
 * Created by aaron.spiteri on 26/09/2016.
 */
public class DigitMapper extends AbstractMapper<DigitBitmap> {
    public DigitMapper() {
        setCharacters(DigitBitmap.values(), DigitBitmap.values().length);
    }
}
