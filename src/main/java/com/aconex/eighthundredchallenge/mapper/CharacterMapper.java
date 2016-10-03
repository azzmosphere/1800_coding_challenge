package com.aconex.eighthundredchallenge.mapper;


/**
 * Maps alpha characters to bitmap.
 *
 * Created by aaron.spiteri on 24/09/2016.
 */
public class CharacterMapper extends AbstractMapper<CharacterBitmap> {

    public CharacterMapper() {
        setCharacters(CharacterBitmap.values(), CharacterBitmap.values().length);
    }
}
