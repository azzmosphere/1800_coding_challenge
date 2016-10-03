package com.aconex.eighthundredchallenge.mapper;

import java.util.HashMap;

/**
 * common base class for mapper classes.
 *
 * Created by aaron.spiteri on 26/09/2016.
 */
public class AbstractMapper<T extends EightHundredBitMap> implements Mapper<T> {

    protected HashMap<Character, T>  characters;

    protected void setCharacters(T[] values, int size) {

        characters = new HashMap<>(size);
        for (T c : values) {
            characters.put(c.getKey(), c);
        }
    }
    /**
     * retrieve the bitmap for a given character c
     *
     * @param c
     * @return bitmask
     */
    public int getBitMask(char c) {
        c = Character.toUpperCase(c);
        return characters.get(c).getBitMask();
    }

    /**
     *
     *  Retrieve the bitmap given a character.
     *
     * @param c
     * @return bitmap
     */
    public T getCharacterBitmap(char c) {
        c = Character.toUpperCase(c);
        return characters.get(c);
    }

    /**
     * assert if character 'c' is with in the characterbitmap
     *
     * @param c
     * @return true on success otherwise false.
     */
    public boolean hasChar(char c) {
        return characters.containsKey(Character.toUpperCase(c));
    }

}